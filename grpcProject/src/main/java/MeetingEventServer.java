import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import gen.proto.grpc.gen.Event;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.swing.text.html.HTMLDocument;

public class MeetingEventServer {
    private static final Logger logger = Logger.getLogger(MeetingEventServer.class.getName());
    private int port = 50052;
    private Server server;
    ConcurrentLinkedQueue<Event> eventQueue = new ConcurrentLinkedQueue<>();
    List<Event> events = new ArrayList<>();
    List<Event> synchroEvents = Collections.synchronizedList(events);

    public static void main(String[] args) {
        final MeetingEventServer server = new MeetingEventServer();
        try {
            server.start();
            server.startGeneratingEvents(server.synchroEvents);
            server.blockUntilShutdown();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
            throw new RuntimeException("IO Failure!");
         }

    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new EventNotifierImpl(synchroEvents))
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                MeetingEventServer.this.stop();
                System.err.println("*** server shut down");
            }
        });

    }

    private void startGeneratingEvents(List<Event> synchroList){
        ExecutorService executor = Executors.newFixedThreadPool(1);

        EventServerGenerator eventServerGenerator = new EventServerGenerator(synchroList);
        Thread generator = new Thread(eventServerGenerator);

        executor.execute(generator);
    }

    private void blockUntilShutdown() {
        if (server != null) {
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Server Interrupted while awaiting termination");
            }
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
}

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

public class MeetingEventServer {
    private static final Logger logger = Logger.getLogger(MeetingEventServer.class.getName());
    private int port = 50052;
    private Server server;
    ConcurrentLinkedQueue<Event> eventQueue = new ConcurrentLinkedQueue<>();
    List<Event> events = new ArrayList<>();
    List<Event> synchroEvents = Collections.synchronizedList(events);

    public static void main(String[] args) throws IOException, InterruptedException {
        final MeetingEventServer server = new MeetingEventServer();
        server.start();

        server.startGeneratingEvents(server.synchroEvents);
        server.blockUntilShutdown();

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

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
}

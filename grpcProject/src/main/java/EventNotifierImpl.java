import gen.proto.grpc.gen.Event;
import gen.proto.grpc.gen.EventNotifierGrpc.EventNotifierImplBase;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class EventNotifierImpl extends EventNotifierImplBase {
    private List<Event> synchroEvents;

    public EventNotifierImpl(List<Event> synchroEvents) {
        this.synchroEvents = synchroEvents;
    }

    @Override
    public void subscribe(gen.proto.grpc.gen.EventType request,
                          io.grpc.stub.StreamObserver<gen.proto.grpc.gen.Event> responseObserver) {
        System.out.println("Subscription request arrive: " + request.getCity() + " " + request.getSubject());


        int eventIterator = 0;

        while (true) {
            boolean send = false;
                if (eventIterator < synchroEvents.size() - 1) {
                        synchronized (synchroEvents) {
                            Event currentEvent = synchroEvents.get(eventIterator);

                            if(isEventValid(currentEvent, request.getCity(), request.getSubject())) {
                                responseObserver.onNext(currentEvent);
                                send = true;
                            }
                            eventIterator++;
                        }
                        if(send) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException iex) {
                                throw new RuntimeException("Exception thrown at interrupt");
                            }
                        }
                }
        }
    }

    protected boolean isEventValid(Event event, String city, String subject){
        if(isCityValid(event, city) && isSubjectValid(event, subject))
            return true;
        return false;
    }

    private boolean isCityValid(Event event, String city){
        if(event.getCity().equals(city) || city.equals(""))
            return true;
        return false;
    }

    private boolean isSubjectValid(Event event, String subject){
        if(event.getSubject().equals(subject) || subject.equals(""))
            return true;
        return false;
    }
}



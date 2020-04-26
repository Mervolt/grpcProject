import gen.proto.grpc.gen.Event;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventServerGenerator implements Runnable {
    private List<Event> synchroList;
    private int eventsAmount = 20;

    public EventServerGenerator(List<Event> synchroList){
        this.synchroList = synchroList;
    }

    @Override
    public void run() {
        EventUtil eventUtil = new EventUtil();
        while (true) {
            synchronized (synchroList) {
                List<Event> freshEvents = eventUtil.generateEvents(eventsAmount);
                synchroList.addAll(freshEvents);
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException iex) {
                throw new RuntimeException("Error while generating events");
            }
        }
    }
}

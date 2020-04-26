import gen.proto.grpc.gen.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventUtil {
    String[] cities = new String[]{"Warsaw", "Krakow", "Gdansk", "Poznan", "Wroclaw",
            "Katowice", "Szczecin", "Gdynia", "Rzeszow", "Lublin"};
    String[] description = new String[]{"Learning meeting", "Java meeting", "Social meeting", "Board games",
    "Engineering project", "Job interview", "Cinema", "Theater", "Job meeting", "Job training"};
    String[] subject = new String[]{"Job", "Entertainment", "Learning"};
    Integer[] vacancies = new Integer[]{2, 4, 8, 16, 32, 64};
    String[] additionalInfo = new String[]{"Good temperature", "Beware of clouds", "You cannot be late",
            "Official character", "No dresscode"};

    protected List<Event> generateEvents(int eventsAmount){
        Random random = new Random();
        List<Event> events = new ArrayList<>();
        for(int i = 0; i < eventsAmount; i++) {
            int cityNumber = random.nextInt(cities.length);
            int descriptionNumber = random.nextInt(description.length);
            int subjectNumber = random.nextInt(subject.length);
            int vacanciesNumber = random.nextInt(vacancies.length);
            Event.Builder eventBuilder = Event.newBuilder().setCity(cities[cityNumber]).setDescription(description[descriptionNumber])
                    .setSubject(subject[subjectNumber]).setVacancies(vacancies[vacanciesNumber]);
            int infoAmount = random.nextInt(additionalInfo.length - 1);
            for(int j = 0; j < infoAmount; j++){
                int infoNumber = random.nextInt(additionalInfo.length - 1);
                eventBuilder.addAdditionalInformation(additionalInfo[infoNumber]);
            }
            Event event = eventBuilder.build();
            events.add(event);
        }
        return events;
    }
}

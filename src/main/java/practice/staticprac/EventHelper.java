package practice.staticprac;

public class EventHelper {
    public static void main(String args[]){
        System.out.println(getEventType(new TennisEvent()));
        System.out.println(getEventType(new FootballEvent()));
    }

    public static String getEventType(SportEvent sportEvent){
        return sportEvent.getEventType().getEventType();
    }
}

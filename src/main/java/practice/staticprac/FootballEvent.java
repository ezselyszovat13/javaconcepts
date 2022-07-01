package practice.staticprac;

public class FootballEvent extends SportEvent{
    private static final EventType EVENT_TYPE = EventType.FOOTBALL_EVENT;

    public FootballEvent() {
        this.eventType = EVENT_TYPE;
    }
}

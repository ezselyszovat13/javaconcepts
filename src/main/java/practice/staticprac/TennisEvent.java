package practice.staticprac;

public class TennisEvent extends SportEvent{
    private static final EventType EVENT_TYPE = EventType.TENNIS_EVENT;

    public TennisEvent() {
        this.eventType = EVENT_TYPE;
    }
}

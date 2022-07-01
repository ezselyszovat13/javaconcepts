package practice.staticprac;

import lombok.Getter;

@Getter
public enum EventType {
    TENNIS_EVENT("tennis"),
    FOOTBALL_EVENT("football");

    private final String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }
}

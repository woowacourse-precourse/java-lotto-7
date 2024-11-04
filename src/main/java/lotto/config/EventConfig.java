package lotto.config;

import lotto.shared.event.EventOrchestrator;
import lotto.shared.event.EventPublisher;
import java.util.ArrayList;

public class EventConfig {

    private EventPublisher eventPublisher;
    private EventOrchestrator eventOrchestrator;

    public EventPublisher getEventPublisher() {
        if (eventPublisher == null) {
            eventPublisher = new EventPublisher(new ArrayList<>());
        }
        return eventPublisher;
    }

    public EventOrchestrator getEventOrchestrator() {
        if (eventOrchestrator == null) {
            eventOrchestrator = new EventOrchestrator();
        }
        return eventOrchestrator;
    }
}

package lotto.shared.event;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {
    private final List<EventListener> listeners;

    public EventPublisher(List<EventListener> request) {
        listeners = new ArrayList<>();
        request.forEach(listener -> listeners.add(listener));
    }

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void publish(DomainEvent event) {
        for (EventListener listener : listeners) {
            listener.handle(event);
        }
    }
}
package lotto.shared.event;

public interface EventListener {
    void handle(DomainEvent event);
}
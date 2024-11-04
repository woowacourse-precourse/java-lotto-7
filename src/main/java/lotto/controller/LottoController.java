package lotto.controller;

import lotto.shared.event.ApplicationStartEvent;
import lotto.shared.event.EventPublisher;

public class LottoController {

    EventPublisher eventPublisher;

    public LottoController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void run() {
        eventPublisher.publish(new ApplicationStartEvent());
    }
}

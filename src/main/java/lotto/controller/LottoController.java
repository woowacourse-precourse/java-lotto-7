package lotto.controller;

import lotto.shared.application.InputService;
import lotto.shared.event.EventPublisher;
import lotto.purchase.domain.Money;
import lotto.purchase.event.MoneyCreatedEvent;

public class LottoController {

    InputService inputService;
    EventPublisher eventPublisher;

    public LottoController(InputService inputService,
                           EventPublisher eventPublisher) {
        this.inputService = inputService;
        this.eventPublisher = eventPublisher;
    }

    public void run() {
        Money money = inputService.getMoney();
        eventPublisher.publish(new MoneyCreatedEvent(money));
    }
}

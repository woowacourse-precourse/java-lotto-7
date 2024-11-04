package lotto.controller;

import lotto.shared.application.InputService;
import lotto.shared.event.EventPublisher;
import lotto.purchase.domain.Money;
import lotto.purchase.event.MoneyCreatedEvent;

public class LottoController {

    InputService inputService;

    public LottoController(InputService inputService,
                           EventPublisher eventPublisher) {
        this.inputService = inputService;
    }

    public void run() {
        Money money = inputService.getMoney();
        inputService.start(money);
    }
}

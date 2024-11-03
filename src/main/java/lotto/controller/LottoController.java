package lotto.controller;

import lotto.domain.Money;
import lotto.service.InputService;
import lotto.service.OutputService;

public class LottoController {
    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();
    public void run() {
        outputService.requestPay();
        Money money = new Money(inputService.inputPaidMoney());
        int amountLotto = money.getAmount();
    }
}

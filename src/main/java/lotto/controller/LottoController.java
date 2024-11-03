package lotto.controller;

import lotto.service.InputService;
import lotto.service.OutputService;

public class LottoController {
    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();
    public void run() {
        outputService.requestPay();
        int money = inputService.inputPaidMoney();
    }
}

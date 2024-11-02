package lotto.controller;

import lotto.service.OutputService;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    public static int AMOUNT = 0;

    private final OutputService outputService;

    public LottoController(OutputService outputService) {
        this.outputService = outputService;
    }

    public void run() {
        outputService.printAmountMessage();
        AMOUNT = Integer.parseInt(Console.readLine());
    }
}

package lotto.controller;

import lotto.service.LottoService;
import lotto.service.OutputService;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    public static int AMOUNT = 0;

    private final OutputService outputService;
    private final LottoService lottoService;

    public LottoController(OutputService outputService, LottoService lottoService) {
        this.outputService = outputService;
        this.lottoService = lottoService;
    }

    public void run() {
        outputService.printAmountMessage();
        AMOUNT = Integer.parseInt(Console.readLine());
        int numberOfLottoes = lottoService.lottoPurchase(AMOUNT);
        outputService.printNumberOfLottoesMessage(numberOfLottoes);
    }
}

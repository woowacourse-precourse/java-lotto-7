package lotto.controller;

import lotto.service.LottoService;
import lotto.service.OutputService;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<List<Integer>> issuedLottoNumbers = lottoService.lottoIssues(numberOfLottoes);
        outputService.printIssuedLottoesMessage(numberOfLottoes, issuedLottoNumbers);

        outputService.printWinningNumberMessage();
        lottoService.winningNumber(Console.readLine());

        outputService.printBonusNumberMessage();
        lottoService.bonusNumber(Console.readLine());

        Map<String, Integer> matchingNumbers = lottoService.winningStatistics();
        outputService.printWinningStatisticsMessage((HashMap<String, Integer>) matchingNumbers);
    }
}

package lotto.domain.controller;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.service.LottoService;
import lotto.domain.util.Statistics;
import lotto.global.io.InputConsole;
import lotto.global.io.OutputConsole;

public class LottoController {

    private final LottoService service;
    private final InputConsole input;
    private final OutputConsole output;

    private static LottoController instance;

    private LottoController(LottoService service, InputConsole input, OutputConsole output) {
        this.service = service;
        this.input = input;
        this.output = output;
    }

    public static LottoController getInstance() {
        assert instance != null : "LottoController has not been initialized";
        return instance;
    }

    public static void init(LottoService service, InputConsole input, OutputConsole output) {
        if (instance != null) return;
        instance = new LottoController(service, input, output);
    }

    public void play() {
        Lotteries lotteries = purchaseLotteries();
        Lotto winningNumber = setWinningNumber();
        Integer bonusNumber = setBonusNumber();

        calculateProfit(lotteries, winningNumber, bonusNumber);
    }

    private Lotteries purchaseLotteries() {
        output.printPurchaseMessage();

        try {
            Lotteries lotteries = service.purchaseLotteries(input.read());
            output.printPurchaseResult(lotteries);
            return lotteries;
        } catch (IllegalArgumentException e) {
            output.printError(e);
            return purchaseLotteries();
        }
    }

    private Lotto setWinningNumber() {
        output.printWinningNumberMessage();

        try {
            return service.setWinningNumber(input.read());
        } catch (IllegalArgumentException e) {
            output.printError(e);
            return setWinningNumber();
        }
    }

    private Integer setBonusNumber() {
        output.printBonusNumberMessage();

        try {
            return service.setBonusNumber(input.read());
        } catch (IllegalArgumentException e) {
            output.printError(e);
            return setBonusNumber();
        }
    }

    private void calculateProfit(Lotteries lotteries, Lotto winningLotto, Integer bonusNumber) {
        Statistics statistics = service.calculateProfit(lotteries, winningLotto, bonusNumber);
        output.printProfitStatistics(statistics);
        output.printProfitRate(statistics.calculateProfitRate());
    }
}

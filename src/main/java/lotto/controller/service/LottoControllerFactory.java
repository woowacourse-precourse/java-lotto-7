package lotto.controller.service;

import lotto.buyer.domain.Buyer;
import lotto.buyer.domain.InsertMoneyService;
import lotto.buyer.infrastructure.InsertWon;
import lotto.buyer.infrastructure.Won;
import lotto.controller.domain.LottoController;
import lotto.controller.domain.WinningLottoController;
import lotto.lotto.domain.LottoMachine;
import lotto.lotto.winning.domain.WinningCalculator;
import lotto.lotto.infrastructure.RandomNumberGenerate;
import lotto.lotto.infrastructure.WonCalculator;
import lotto.view.input.hanlder.infrastructure.MoneyHandler;
import lotto.view.input.infrastructure.MoneyInput;
import lotto.view.output.domain.ResultViewService;
import lotto.view.output.infrastructure.*;

public class LottoControllerFactory {
    public static LottoController create() {
        InsertMoneyService insertMoneyService = createInsertMoneyService();
        Buyer buyer = createBuyer(insertMoneyService);
        LottoMachine lottoMachine = createLottoMachine();
        ResultViewService resultViewService = createResultViewService();
        WinningLottoController winningLottoController = WinningLottoControllerFactory.create();
        WinningCalculator winningCalculator = createWinningCalculator();
        return new LottoController(buyer, lottoMachine, resultViewService, winningLottoController, winningCalculator);
    }

    private static InsertMoneyService createInsertMoneyService() {
        return new InsertWon(new MoneyHandler(new MoneyInput(new MoneyOutput())));
    }

    private static Buyer createBuyer(InsertMoneyService insertMoneyService) {
        return new Buyer(insertMoneyService);
    }

    private static LottoMachine createLottoMachine() {
        return new LottoMachine(new WonCalculator(), new RandomNumberGenerate(), new PurchaseOutput());
    }

    private static ResultViewService createResultViewService() {
        return new CommonResultOutput();
    }

    private static WinningCalculator createWinningCalculator() {
        return new WinningCalculator(new Won());
    }
}

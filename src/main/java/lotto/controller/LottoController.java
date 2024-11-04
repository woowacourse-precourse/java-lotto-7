package lotto.controller;

import lotto.handler.MainLogicHandler;
import lotto.view.OutputView;


public class LottoController {
    private final MainLogicHandler mainLogicHandler;

    public LottoController() {
        this.mainLogicHandler = new MainLogicHandler();
    }

    public void run() {
        OutputView.printInputPurchaseMoneyMessage();
        mainLogicHandler.handlePurchaseMoney();
        mainLogicHandler.handleLottos();

        OutputView.printInputWinningNumbers();
        mainLogicHandler.handleWinningLotto();

        OutputView.printInputBonusNumber();
        mainLogicHandler.handleBonusNumber();
        mainLogicHandler.handleMatchCounts();
        mainLogicHandler.handleRateOfReturn();
        OutputView.printRateOfReturn(mainLogicHandler.getRateOfReturn());
    }
}

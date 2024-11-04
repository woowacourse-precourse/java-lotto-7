package lotto.controller;

import lotto.domain.*;
import lotto.utils.InputRetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = new LottoGame();
    }

    public void run() {
        Purchase purchase = handlePurchase();
        buyAndPrintLottos(purchase);

        WinningNumbers winningNumbers = handleWinningNumbersInput();
        BonusNumber bonusNumber = handleBonusNumberInput(winningNumbers);

        calculateAndPrintStatistics(winningNumbers, bonusNumber, purchase);
    }

    private Purchase handlePurchase() {
        return InputRetryHandler.handleInput(() -> {
            int amount = inputView.readPurchaseAmount();
            return new Purchase(amount);
        }, outputView);
    }

    private void buyAndPrintLottos(Purchase purchase) {
        lottoGame.buyLottos(purchase.getLottoCount());
        outputView.printLottos(lottoGame.getLottos());
    }

    private WinningNumbers handleWinningNumbersInput() {
        return InputRetryHandler.handleInput(
                () -> new WinningNumbers(inputView.readWinningNumbers()), outputView);
    }

    private BonusNumber handleBonusNumberInput(WinningNumbers winningNumbers) {
        return InputRetryHandler.handleInput(
                () -> new BonusNumber(inputView.readBonusNumber(), winningNumbers), outputView);
    }

    private void calculateAndPrintStatistics(WinningNumbers winningNumbers, BonusNumber bonusNumber, Purchase purchase) {
        Statistics statistics = new Statistics(lottoGame.getLottos(), winningNumbers, bonusNumber, purchase);
        outputView.printStatistics(statistics.getResults(), statistics.calculateYield());
    }
}

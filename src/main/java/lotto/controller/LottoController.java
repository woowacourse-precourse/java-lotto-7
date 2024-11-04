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
        Purchase purchase = InputRetryHandler.handleInput(() -> {
            int amount = inputView.readPurchaseAmount();
            return new Purchase(amount);
        }, outputView);

        lottoGame.buyLottos(purchase.getLottoCount());
        outputView.printLottos(lottoGame.getLottos());

        WinningNumbers winningNumbers = InputRetryHandler.handleInput(
                () -> new WinningNumbers(inputView.readWinningNumbers()), outputView);

        BonusNumber bonusNumber = InputRetryHandler.handleInput(
                () -> new BonusNumber(inputView.readBonusNumber(), winningNumbers), outputView);

        Statistics statistics = new Statistics(lottoGame.getLottos(), winningNumbers, bonusNumber, purchase);
        outputView.printStatistics(statistics.getResults(), statistics.calculateYield());
    }
}

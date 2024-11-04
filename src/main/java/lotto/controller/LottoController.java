package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoGame;
import lotto.domain.Purchase;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;
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
        int amount = readValidPurchaseAmount();
        Purchase purchase = new Purchase(amount);
        lottoGame.buyLottos(purchase.getLottoCount());
        outputView.printLottos(lottoGame.getLottos());

        WinningNumbers winningNumbers = readWinningNumbers();
        BonusNumber bonusNumber = readBonusNumber(winningNumbers);
        Statistics statistics = new Statistics(lottoGame.getLottos(), winningNumbers, bonusNumber, purchase);
        outputView.printStatistics(statistics.getResults(), statistics.calculateYield());
    }

    private int readValidPurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.readPurchaseAmount();
                return new Purchase(amount).getAmount();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return new WinningNumbers(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber readBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                int number = inputView.readBonusNumber();
                return new BonusNumber(number, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}

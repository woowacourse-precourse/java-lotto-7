package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> purchasedLottos = LottoGenerator.generateLottos(purchaseAmount);
        OutputView.printPurchasedLottos(purchasedLottos);
        Lotto winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber(winningLotto);
        WinningStatistics statistics = LottoResultCalculator.calculate(purchasedLottos, winningLotto, bonusNumber);
        OutputView.printWinningStatistics(statistics, purchaseAmount);
    }

    public int inputPurchaseAmount() {
        while (true) {
            try {
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputWinningLotto() {
        while (true) {
            try {
                return InputView.inputWinningLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return InputView.inputBonusNumber(winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


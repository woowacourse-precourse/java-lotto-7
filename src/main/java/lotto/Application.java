package lotto;

import lotto.model.Lotto;
import lotto.controller.LottoMachine;
import lotto.model.Win;
import lotto.view.InputView;
import lotto.view.OutputView;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchaseAmount = InputView.Purchase();
        List<Lotto> purchasedLottos = LottoMachine.generateLottos(purchaseAmount);

        OutputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = InputView.WinningNumbers();
        int bonusNumber = InputView.BonusNumber(winningNumbers);

        Win win = new Win(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printWinningStatistics(win, purchaseAmount);

    }
}

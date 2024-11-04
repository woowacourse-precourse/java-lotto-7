package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.util.GenerateLotto;
import lotto.util.PurchaseValidator;
import lotto.util.WinningLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            OutputView.printPurchaseAmountMsg();
            int purchaseAmount = InputView.getPurchaseAmount();
            PurchaseValidator.validatePurchase(purchaseAmount);

            int lottosCount = purchaseAmount / 1000;
            OutputView.printLottoCount(lottosCount);

            List<Lotto> lottos = GenerateLotto.generateLottos(lottosCount);
            OutputView.printLottos(lottos);

            OutputView.printWinnerLotto();
            List<Integer> winningLotto = InputView.getWinningLotto();
            WinningLottoValidator.validateLotto(winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
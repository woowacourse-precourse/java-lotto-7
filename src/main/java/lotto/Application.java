package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoWinningNumbersController;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;

public class Application {

    private static final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();
    private static final LottoWinningNumbersController lottoWinningNumbersController = new LottoWinningNumbersController();

    public static void main(String[] args) {

        long userPurchaseMoney = InputView.inputPurchaseMoney();
        Lottos lottos = lottoPurchaseController.purchaseLottos(userPurchaseMoney);
        OutputView.showPurchasedLottos(lottos);

        Set<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber();
        LottoWinningNumbers lottoWinningNumbers = lottoWinningNumbersController.determineLottoWinningNumbers(winningNumbers, bonusNumber);

        OutputView.showPurchasedLottosStatus(lottoWinningNumbers, lottos, userPurchaseMoney);
    }
}

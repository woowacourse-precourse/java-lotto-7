package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static final LottoPurchaseController lottoPurchaseController = new LottoPurchaseController();

    public static void main(String[] args) {

        long userPurchaseMoney = InputView.inputPurchaseMoney();
        long purchasedLottoCount = lottoPurchaseController.purchaseLottoCount(userPurchaseMoney);
        OutputView.showPurchasedLottoCount(purchasedLottoCount);
        Lottos lottos = lottoPurchaseController.purchaseLottos(purchasedLottoCount);
        OutputView.showPurchasedLottos(lottos);

        LottoWinningNumbers lottoWinningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusWinningNumber();
        lottoWinningNumbers.addBonusWinningNumber(bonusNumber);

        OutputView.showPurchasedLottosStatus(lottoWinningNumbers, lottos, userPurchaseMoney);
    }
}

package lotto;

import lotto.controller.LottoDrawingController;
import lotto.controller.LottoPurchaseController;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.BonusNumberInputView;
import lotto.view.PurchaseAmountInputView;
import lotto.view.WinningNumbersInputView;

public class LottoApplication {
    public static void run() {
        Lottos lottos = new Lottos();
        LottoPurchase lottoPurchase = new LottoPurchase();

        getLottoPurchaseController(lottos, lottoPurchase).start();
        getLottoDrawingController(lottos, lottoPurchase).start();
    }

    private static LottoPurchaseController getLottoPurchaseController(Lottos lottos, LottoPurchase lottoPurchase) {
        PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();

        return new LottoPurchaseController(lottos, lottoPurchase, purchaseAmountInputView);
    }

    private static LottoDrawingController getLottoDrawingController(Lottos lottos, LottoPurchase lottoPurchase) {
        WinningNumbersInputView winningNumbersInputView = new WinningNumbersInputView();
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();

        return new LottoDrawingController(
                lottos,
                lottoPurchase,
                winningNumbersInputView,
                bonusNumberInputView
        );
    }
}

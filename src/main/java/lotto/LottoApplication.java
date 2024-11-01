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

        PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();

        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(lottos, lottoPurchase,
                purchaseAmountInputView);
        lottoPurchaseController.start();

        WinningNumbersInputView winningNumbersInputView = new WinningNumbersInputView();
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();

        LottoDrawingController lottoDrawingController = new LottoDrawingController(
                lottos,
                lottoPurchase,
                winningNumbersInputView,
                bonusNumberInputView
        );

        lottoDrawingController.start();
    }
}

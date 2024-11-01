package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.PurchaseAmountInputView;

public class LottoApplication {
    public static void run() {
        Lottos lottos = new Lottos();
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(lottos, lottoPurchase);

        PurchaseAmountInputView purchaseAmountInputView = new PurchaseAmountInputView();
        purchaseAmountInputView.printPurchaseAmountInputGuide();

        lottoPurchaseController.start(purchaseAmountInputView.getPurchaseAmount());
    }
}

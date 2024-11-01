package lotto;

import lotto.controller.LottoPurchaseController;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.view.PurchaseAmountInputView;
import lotto.view.WinningNumbersInputView;

public class LottoApplication {
    public static void run() {
        Lottos lottos = new Lottos();
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(lottos, lottoPurchase);

        lottoPurchaseController.start();

        
    }
}

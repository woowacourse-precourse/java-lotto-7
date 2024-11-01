package lotto;

import lotto.controller.LottoDrawingController;
import lotto.controller.LottoPurchaseController;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;

public class LottoApplication {
    public static void run() {
        Lottos lottos = new Lottos();
        LottoPurchase lottoPurchase = new LottoPurchase();

        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(lottos, lottoPurchase);
        lottoPurchaseController.start();

        LottoDrawingController lottoDrawingController = new LottoDrawingController(lottos, lottoPurchase);
        lottoDrawingController.start();
    }
}

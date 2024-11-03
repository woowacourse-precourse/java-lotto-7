package lotto;

import lotto.controller.BuyLottoController;
import lotto.controller.LottoPurchaseController;
import lotto.controller.LottoResultController;

/**
 * 애플리케이션은 말그대로 게임을 실행만 해야한다.
 */
public class Application {
    public static void main(String[] args) {
        BuyLottoController buyLottoController = new BuyLottoController();
        buyLottoController.checkExcepForInputPrice();
        LottoPurchaseController lottoPurchaseController = new LottoPurchaseController(buyLottoController.getBuyCount());
        lottoPurchaseController.printPurchaseLotto();
        LottoResultController resultController = new LottoResultController(lottoPurchaseController.getBuyLottoInfoList(),buyLottoController.getBuyPrice());
        resultController.outputResult();
    }
}

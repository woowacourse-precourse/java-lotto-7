package lotto;

import lotto.controller.LottoController;
import lotto.view.PurchaseView;

public class Application {
    public static void main(String[] args) {

        PurchaseView purchaseView = new PurchaseView();

        LottoController lottoController = new LottoController(purchaseView);
        lottoController.run();
    }
}

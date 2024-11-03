package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.view.PurchaseView;

public class Application {
    public static void main(String[] args) {

        PurchaseView purchaseView = new PurchaseView();

        InputController inputController = new InputController(purchaseView);

        LottoController lottoController = new LottoController(inputController);
        lottoController.run();
    }
}

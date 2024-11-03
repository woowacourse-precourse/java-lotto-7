package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.view.PurchaseView;
import lotto.view.UserLottoListView;

public class Application {
    public static void main(String[] args) {

        PurchaseView purchaseView = new PurchaseView();
        InputController inputController = new InputController(purchaseView);

        UserLottoListView userLottoListView = new UserLottoListView();

        LottoController lottoController = new LottoController(inputController, userLottoListView);
        lottoController.run();
    }
}

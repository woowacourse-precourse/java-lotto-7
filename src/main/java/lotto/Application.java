package lotto;

import lotto.system.controller.ShopController;
import lotto.system.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            ShopController shop = ShopController.visitShop();
            shop.buyLottos();
            shop.checkLottoResult();
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(String.valueOf(e));
        }
    }
}

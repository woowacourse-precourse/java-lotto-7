package lotto;

import lotto.controller.Shop;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            Shop shop = Shop.visitShop();
            shop.buyLottos();
            shop.checkLottoResult();
        } catch (RuntimeException e) {
            OutputView.showErrorMessage(String.valueOf(e));
        }
    }
}

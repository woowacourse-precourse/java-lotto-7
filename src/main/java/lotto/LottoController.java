package lotto;

import static lotto.Consumer.enterPurchaseAmount;
import static lotto.Seller.setInputPurchaseAmount;

public class LottoController {
    public void start() {
        setInputPurchaseAmount();
        int purchaseAmount = enterPurchaseAmount();
    }
}

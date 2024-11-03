package lotto;

import static lotto.Consumer.enterPurchaseAmount;
import static lotto.Seller.getHowManyLottoMessage;
import static lotto.Seller.setInputPurchaseAmount;

public class LottoController {
    public void start() {
        setInputPurchaseAmount();
        int purchaseAmount = enterPurchaseAmount();
        System.out.println(getHowManyLottoMessage(purchaseAmount));
    }
}

package lotto;

import static lotto.Consumer.enterPurchaseAmount;
import static lotto.Seller.countNumberOfLotto;
import static lotto.Seller.getHowManyLottoMessage;
import static lotto.Seller.giveLotto;
import static lotto.Seller.setInputPurchaseAmount;

public class LottoController {
    public void start() {
        setInputPurchaseAmount();
        int purchaseAmount = enterPurchaseAmount();
        int numberOfLotto = countNumberOfLotto(purchaseAmount);
        System.out.println();
        System.out.println(getHowManyLottoMessage(numberOfLotto));
        giveLotto(numberOfLotto);
    }
}

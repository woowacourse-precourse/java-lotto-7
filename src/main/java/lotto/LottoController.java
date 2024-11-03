package lotto;

import static lotto.Consumer.enterPurchaseAmount;
import static lotto.Consumer.enterWinningNumbers;
import static lotto.Consumer.getWinningNumbers;
import static lotto.Seller.countNumberOfLotto;
import static lotto.Seller.getHowManyLottoMessage;
import static lotto.Seller.giveLotto;
import static lotto.Seller.setInputPurchaseAmount;
import static lotto.Seller.setWinningNumbers;

import java.util.List;

public class LottoController {
    public void start() {
        setInputPurchaseAmount();
        int purchaseAmount = enterPurchaseAmount();
        int numberOfLotto = countNumberOfLotto(purchaseAmount);
        System.out.println();
        System.out.println(getHowManyLottoMessage(numberOfLotto));
        giveLotto(numberOfLotto);
        System.out.println();
        setWinningNumbers();
        List<Integer> winningNumbers = getWinningNumbers();
    }
}

package lotto.view;

import java.util.List;
import lotto.constant.PurchaseOutputMessage;
import lotto.model.Lotto;

public class PurchaseOutputView {

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.printf(PurchaseOutputMessage.NUMBER_OF_PURCHASED_LOTTO.getMessage(), purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }
}

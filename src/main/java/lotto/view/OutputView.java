package lotto.view;

import static lotto.view.OutputMessage.OUTPUT_PURCHASE_QUANTITY;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void displayPurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        displayPurchaseQuantity(purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            lotto.showNumbers();
        }
    }

    private static void displayPurchaseQuantity(int lottoQuantity) {
        System.out.println(OUTPUT_PURCHASE_QUANTITY.format(lottoQuantity));
    }
}

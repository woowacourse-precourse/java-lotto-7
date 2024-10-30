package lotto;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";

    public static void displayPurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        displayPurchaseQuantity(purchasedLotto.size());
        for (Lotto lotto : purchasedLotto) {
            lotto.showNumbers();
        }
    }

    private static void displayPurchaseQuantity(int lottoQuantity) {
        System.out.println(LINE_BREAK + lottoQuantity + PURCHASE_QUANTITY_MESSAGE);
    }
}

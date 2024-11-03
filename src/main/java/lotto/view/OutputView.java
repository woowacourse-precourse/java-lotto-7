package lotto.view;

import lotto.Lotto;
import lotto.PurchasedLottos;

import java.util.TreeSet;

public class OutputView {

    public static void showPurchasedLottosQuantity(int quantity) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
    }

    public static void showPurchasedLottos(String purchasedLottos) {
        System.out.println(purchasedLottos);
    }

}

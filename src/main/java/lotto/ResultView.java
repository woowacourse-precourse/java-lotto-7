package lotto;

import java.util.List;

public class ResultView {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}

package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printPurchaseCount(int count) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", count);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}


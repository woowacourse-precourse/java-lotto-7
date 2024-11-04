package lotto.view.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
        public static void printPurchaseCount(int count) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}

package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.getSize());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}

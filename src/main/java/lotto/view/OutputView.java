package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";

    public void printPurchaseCount(int count) {
        System.out.printf((PURCHASE_COUNT_FORMAT) + "%n", count);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }
}

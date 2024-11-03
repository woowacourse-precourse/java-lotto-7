package lotto.view;

import lotto.model.Lottos;

public class OutputView {
    private static final String PURCHASE_LOTTOS_MESSAGE = "%d개를 구매했습니다.\n";

    public void printPurchaseLottos(Lottos lottos) {
        int buyCount = lottos.getCount();

        System.out.printf(PURCHASE_LOTTOS_MESSAGE, buyCount);
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }
}

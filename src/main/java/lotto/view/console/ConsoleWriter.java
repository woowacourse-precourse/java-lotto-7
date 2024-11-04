package lotto.view.console;

import lotto.view.OutputView;

public class ConsoleWriter implements OutputView {
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    @Override
    public void printPurchasedLottoCount(int count) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE + "%n", count);
    }
}

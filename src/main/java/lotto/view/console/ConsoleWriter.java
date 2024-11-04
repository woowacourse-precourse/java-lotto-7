package lotto.view.console;

import lotto.view.OutputView;

public class ConsoleWriter implements OutputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    @Override
    public void printPurchaseAmountRequest() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    @Override
    public void printPurchasedLottoCount(int count) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE + "%n", count);
    }
}

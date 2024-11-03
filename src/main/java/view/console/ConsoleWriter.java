package view.console;

import view.OutputView;

public class ConsoleWriter implements OutputView {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    @Override
    public void printPurchaseAmountRequest() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }
}

package lotto.view;

import lotto.message.ExceptionMessage;

public class OutputView {
    public static final String REQUEST_PURCHASE_MONEY_AMOUNT = "구입금액을 입력해 주세요.";

    public static void printRequestPurchaseMoney() {
        printMessage(REQUEST_PURCHASE_MONEY_AMOUNT);
    }

    public static void printException(IllegalArgumentException e) {
        printMessage(ExceptionMessage.PREFIX + e.getMessage());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}

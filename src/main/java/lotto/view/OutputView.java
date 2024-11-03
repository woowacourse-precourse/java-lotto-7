package lotto.view;

public class OutputView {
    public static final String REQUEST_PURCHASE_MONEY_AMOUNT = "구입금액을 입력해 주세요.";

    public static void requestPurchaseMoney() {
        printMessage(REQUEST_PURCHASE_MONEY_AMOUNT);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}

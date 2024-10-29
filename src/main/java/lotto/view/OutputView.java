package lotto.view;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "\n구입금액을 입력해 주세요.";

    public static void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}

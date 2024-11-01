package lotto.view;

public class OutputView {

    private static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";

    private OutputView() {
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println(purchaseAmountMessage);
    }
}

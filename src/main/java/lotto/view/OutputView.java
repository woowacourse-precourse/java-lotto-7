package lotto.view;

public class OutputView {

    private static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
    private static final String winningNumbers = "당첨 번호를 입력해 주세요.";

    private OutputView() {
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println(purchaseAmountMessage);
    }

    public static void printInputWinningNumbers() {
        System.out.println(winningNumbers);
    }
}

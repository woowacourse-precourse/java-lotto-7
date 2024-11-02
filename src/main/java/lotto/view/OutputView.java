package lotto.view;

public class OutputView {
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_NUM_LOTTO = "%d개를 구매했습니다.";

    public void printPurchaseAmountRequestMessage() {
        printMessage(PURCHASE_AMOUNT_REQUEST);
    }

    public void printNumLotto(long numLotto) {
        printNewLine();
        printMessage(String.format(PURCHASED_NUM_LOTTO, numLotto));
    }

    public void printExitMessage(String message) {
        printMessage(message);
    }

    private void printNewLine() {
        printMessage("");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}

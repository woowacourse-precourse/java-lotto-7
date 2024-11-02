package lotto.view;

public class OutputView {
    private OutputView() {
    }

    public static void printPurChaseAmountInputMessage() {
        printMessage("구입금액을 입력해 주세요.");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        printMessage(message);
    }
}

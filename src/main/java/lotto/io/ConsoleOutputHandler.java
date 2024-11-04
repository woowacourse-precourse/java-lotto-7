package lotto.io;

public class ConsoleOutputHandler {
    private final String buyAmountMessage = "구입금액을 입력해 주세요.";
    public void buyAmountMessage() {
        System.out.println(buyAmountMessage);
    }

    public void exceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}

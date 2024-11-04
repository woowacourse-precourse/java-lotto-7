package lotto.io;

public class ConsoleOutputHandler {
    private final String buyAmountMessage = "구입금액을 입력해 주세요.";
    private final String lottoAmountMessage = "개를 구매했습니다.";
    public void buyAmountMessage() {
        System.out.println(buyAmountMessage);
    }

    public void exceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void lottoAmountMessage(int lottoAmount) {
        System.out.println(lottoAmount+lottoAmountMessage);
    }
}

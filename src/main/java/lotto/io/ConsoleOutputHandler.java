package lotto.io;

import java.util.List;

public class ConsoleOutputHandler {
    private final static String BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private final static String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static void buyAmountMessage() {
        System.out.println(BUY_AMOUNT_MESSAGE);
    }

    public static void exceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void lottoAmountMessage(int lottoAmount) {
        System.out.println(lottoAmount+ LOTTO_AMOUNT_MESSAGE);
    }

    public static void buyLottoNumberMessage(List<Integer> numbers){
        System.out.println(numbers.toString());
    }

    public static void winningNumberMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }
}

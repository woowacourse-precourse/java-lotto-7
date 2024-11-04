package lotto.io;

import java.util.List;

public class ConsoleOutputHandler {
    private final static String buyAmountMessage = "구입금액을 입력해 주세요.";
    private final static String lottoAmountMessage = "개를 구매했습니다.";
    public static void buyAmountMessage() {
        System.out.println(buyAmountMessage);
    }

    public static void exceptionMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void lottoAmountMessage(int lottoAmount) {
        System.out.println(lottoAmount+lottoAmountMessage);
    }

    public static void buyLottoNumberMessage(List<Integer> numbers){
        System.out.println(numbers.toString());
    }
}

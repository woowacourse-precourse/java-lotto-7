package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return input();
    }

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return input();
    }

    private static String input() {
        return Console.readLine();
    }
}

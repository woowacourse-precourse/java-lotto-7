package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String GET_WINNER_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputAmount() {
        System.out.println(INPUT_AMOUNT);
        return Console.readLine();
    }

    public static String getWinnerNumbers() {
        System.out.println(GET_WINNER_NUMBERS);
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER);
        return Console.readLine();
    }
}

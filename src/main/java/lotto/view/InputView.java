package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getBuyAmount() {
        printPrompt(BUY_AMOUNT);
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        printPrompt(WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String getBonusNumber() {
        printPrompt(BONUS_NUMBER);
        return Console.readLine();
    }

    private static void printPrompt(String prompt) {
        System.out.println(prompt);
    }
}

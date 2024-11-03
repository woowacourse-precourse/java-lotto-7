package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.PromptMessages.BUY_AMOUNT;
import static lotto.constant.PromptMessages.WINNING_NUMBERS;
import static lotto.constant.PromptMessages.BONUS_NUMBER;

public class InputView {
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

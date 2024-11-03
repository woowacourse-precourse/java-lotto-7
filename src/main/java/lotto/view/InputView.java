package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.common.constants.ViewMessage.*;

public class InputView {

    public static String readInput() {
        return Console.readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseAmountPrompt() {
        printMessage(PURCHASE_AMOUNT.getText());
    }

    public static void printWinningNumbersPrompt() {
        printMessage(WINNING_NUMBERS.getText());
    }

    public static void printBonusNumbersPrompt() {
        printMessage(BONUS_NUMBER.getText());
    }

}
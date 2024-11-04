package lotto;

import static lotto.OutputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.OutputMessage.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.OutputMessage.INPUT_WINNING_NUMBERS_MESSAGE;

public class OutputHandler {
    private OutputHandler() {
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}

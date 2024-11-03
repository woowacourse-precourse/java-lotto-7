package lotto.view;

public class OutputPrompt extends OutputView {

    /**
     * Constants that only use in OutputView
     */
    // Message for Input announcement
    public static final String MSG_INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String MSG_INPUT_WINNER_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    /**
     * METHODS
     */

    public static void printPurchaseAmountPrompt() {
        System.out.println(MSG_INPUT_PURCHASE_MONEY);
    }

    public static void printWinnerNumbersPrompt() {
        printEmptyLine();
        System.out.println(MSG_INPUT_WINNER_NUMBERS);
    }

    public static void printBonusNumbersPrompt() {
        printEmptyLine();
        System.out.println(MSG_INPUT_BONUS_NUMBER);
    }
}

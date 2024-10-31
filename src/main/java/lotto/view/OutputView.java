package lotto.view;

public class OutputView {

    /**
     * Constants that only use in OutputView
     */
    // Message for Input announcement
    public static final String MSG_INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String MSG_INPUT_WINNER_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    // Message for Result header or tail
    public static final String RESULT_NEW_LOTTO_COUNT = "개를 구매했습니다.";
    public static final String RESULT_STATISTICS_HEADER = "당첨 통계\n---";
    public static final String RESULT_PROFIT_RATE_HEADER = "총 수익률은 ";
    public static final String RESULT_PROFIT_RATE_TAIL = "%입니다.";

    /**
     * METHODS
     */
    public static void printPurchaseAmountPrompt() {
        System.out.println(MSG_INPUT_PURCHASE_MONEY);
    }

    public static void printWinnerNumbersPrompt() {
        System.out.println(MSG_INPUT_WINNER_NUMBERS);
    }

    public static void printBonusNumbersPrompt() {
        System.out.println(MSG_INPUT_BONUS_NUMBER);
    }
}
package lotto.view;

import static lotto.view.Prompt.BONUS_NUMBER;
import static lotto.view.Prompt.PURCHASE_AMOUNT;
import static lotto.view.Prompt.WINNING_NUMBERS;

public class OutputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_NOTICE_HEADER = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";

    public static void displayPrompt(Prompt prompt) {
        if (prompt.equals(PURCHASE_AMOUNT)) {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
        }

        if (prompt.equals(WINNING_NUMBERS)) {
            System.out.println(WINNING_NUMBERS_PROMPT);
        }

        if (prompt.equals(BONUS_NUMBER)) {
            System.out.println(BONUS_NUMBER_PROMPT);
        }
    }
}

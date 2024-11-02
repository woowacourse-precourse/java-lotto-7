package lotto.view;

import static lotto.CommonSymbols.NEW_LINE;
import static lotto.view.Prompt.BONUS_NUMBER;
import static lotto.view.Prompt.PURCHASE_AMOUNT;
import static lotto.view.Prompt.WINNING_NUMBERS;

import java.util.Map;

public class OutputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_NOTICE_HEADER = "개를 구매했습니다.";
    private static final String MATCH_3_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String MATCH_4_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String MATCH_5_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String MATCH_5_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String MATCH_6_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";

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

    public static void displayLottoNumber(int size, String formattedLottoNumbers) {
        String result = NEW_LINE.getSymbol() + size + PURCHASE_NOTICE_HEADER
                + NEW_LINE.getSymbol() + formattedLottoNumbers + NEW_LINE.getSymbol();

        System.out.println(result);
    }

    public static void displayWinningResult(Map<Integer, Integer> winningResult) {
        StringBuilder result = new StringBuilder();
        result.append(NEW_LINE.getSymbol() + WINNING_STATISTICS_HEADER + NEW_LINE.getSymbol()
                + DIVIDER + NEW_LINE.getSymbol());

        for (int i = 3; i <= 5; i++) {
            if (i == 3) {
                result.append(MATCH_3_MESSAGE);
            }

            if (i == 4) {
                result.append(MATCH_4_MESSAGE);
            }

            if (i == 5) {
                result.append(MATCH_5_MESSAGE);
            }

            result.append(winningResult.get(i) + NEW_LINE.getSymbol());
        }

        result.append(MATCH_5_BONUS_MESSAGE + winningResult.get(-5) + NEW_LINE.getSymbol());
        result.append(MATCH_6_MESSAGE + winningResult.get(6) + NEW_LINE.getSymbol());

        System.out.println(result);
    }
}

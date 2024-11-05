package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Prize;

public class OutputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String RESULT_SEPARATOR = "---";
    private static final String PROFIT_RATIO_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final String MATCH_COUNT_FORMAT = "%d개 일치%s (%s원) - %d개%n";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
    }

    public static void printPurchaseLottoCount(int count) {
        System.out.println(System.lineSeparator() + count + PURCHASE_LOTTO_COUNT);
    }

    public static void printEachLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printWinningNumberInputMessage() {
        System.out.println(System.lineSeparator() + WINNING_NUMBER_INPUT);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(System.lineSeparator() + BONUS_NUMBER_INPUT);
    }

    public static void printWinningStatisticsMessage() {
        System.out.println(System.lineSeparator() + WINNING_STATISTICS);
        System.out.println(RESULT_SEPARATOR);
    }

    public static void printResult(Map<Prize, Integer> lottoResult) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        for (Prize prize : Prize.values()) {
            int count = lottoResult.getOrDefault(prize, 0);
            String formattedPrizeMoney = numberFormat.format(prize.getPrizeMoney());
            System.out.printf(MATCH_COUNT_FORMAT,
                    prize.getMatchCount(),
                    prize.isMatchBonus() ? BONUS_BALL_MATCH : "",
                    formattedPrizeMoney,
                    count);
        }
    }

    public static void printProfitRatio(double profitRatio) {
        System.out.printf(PROFIT_RATIO_MESSAGE, profitRatio);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}

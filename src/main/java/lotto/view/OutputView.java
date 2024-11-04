package lotto.view;

import lotto.model.WinningLotto;
import java.util.List;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESPONSE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String SEPARATOR_LINE = "---";
    private static final String COUNT_UNIT = "개";
    private static final String FRONT_PROFIT_RATE = "총 수익률은 ";
    private static final String BACK_PROFIT_RATE = "%입니다.";

    public static void printPurchasedLotto(int lottoCount, List<String> purchasedLotto) {
        System.out.println(NEW_LINE + lottoCount + RESPONSE_LOTTO_COUNT);

        for (String lotto : purchasedLotto) {
            System.out.println(OPEN_BRACKET + lotto + CLOSE_BRACKET);
        }
    }

    public static void printWinningResult() {
        System.out.println(NEW_LINE + WINNING_STATISTICS_TITLE + NEW_LINE + SEPARATOR_LINE);

        for (WinningLotto winning : WinningLotto.values()) {
            System.out.println(winning.getDescription() + winning.getMatchCount() + COUNT_UNIT);
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(FRONT_PROFIT_RATE + profitRate + BACK_PROFIT_RATE);
    }
}

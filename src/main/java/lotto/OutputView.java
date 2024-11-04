package lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_RESULT_FORMAT = "%d개를 구매했습니다.";
    private static final String MATCH_RESULT_FORMAT = "%s - %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원)";
    private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원)";
    private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원)";
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원)";

    public void printPurchaseAmount(int count) {
        System.out.println();
        System.out.printf(PURCHASE_RESULT_FORMAT, count);
        System.out.println();
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printStatistics(LottoStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printPrizeResult(FIFTH_PRIZE_MESSAGE, statistics.getRankCount(Rank.FIFTH));
        printPrizeResult(FOURTH_PRIZE_MESSAGE, statistics.getRankCount(Rank.FOURTH));
        printPrizeResult(THIRD_PRIZE_MESSAGE, statistics.getRankCount(Rank.THIRD));
        printPrizeResult(SECOND_PRIZE_MESSAGE, statistics.getRankCount(Rank.SECOND));
        printPrizeResult(FIRST_PRIZE_MESSAGE, statistics.getRankCount(Rank.FIRST));
    }

    private void printPrizeResult(String message, int count) {
        System.out.printf(MATCH_RESULT_FORMAT, message, count);
        System.out.println();
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT, profitRate);
        System.out.println();
    }
}

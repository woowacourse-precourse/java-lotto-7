package lotto;

public class OutputView {
    private static final String PURCHASED_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String RANKING_MESSAGE_FORMAT = "%s - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String NEW_LINE = "\n";

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.printf(PURCHASED_MESSAGE, lottos.size());
        System.out.println(String.join(NEW_LINE, lottos.getAllLottoNumbers()));
    }

    public static void printWinningStatistics(LottoResult result) {
        System.out.println(WINNING_STATISTICS_HEADER);

        for (LottoRanking ranking : LottoRanking.values()) {
            if (ranking != LottoRanking.NONE) {
                System.out.printf(RANKING_MESSAGE_FORMAT, ranking.getMessage(), result.getResultCount(ranking));
            }
        }
    }

    public static void printProfitRate(double profit) {
        System.out.printf(PROFIT_RATE_MESSAGE, profit);
    }
}

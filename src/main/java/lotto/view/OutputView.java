package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printResult(LottoResult lottoResult, int purchaseAmount) {
        System.out.println(STATISTICS_HEADER);
        printWinningStatistics(lottoResult.getRankCounts());
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        printProfitRate(profitRate);
    }

    private static void printWinningStatistics(Map<Rank, Integer> rankCounts) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            printRankResult(rank, rankCounts.get(rank));
        }
    }

    private static void printRankResult(Rank rank, int count) {
        String message = generateRankMessage(rank, count);
        System.out.println(message);
    }

    private static String generateRankMessage(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    rank.getMatchCount(), formatPrize(rank.getPrize()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개",
                rank.getMatchCount(), formatPrize(rank.getPrize()), count);
    }

    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    private static void printProfitRate(double profitRate) {
        if (profitRate >= 100.0) {
            System.out.println(String.format(TOTAL_PROFIT_RATE_MESSAGE, profitRate));
        } else {
            System.out.println(String.format(TOTAL_PROFIT_RATE_MESSAGE, profitRate));
        }
    }

    public static void printPurchaseCount(int count) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", count);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}


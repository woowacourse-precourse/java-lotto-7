package lotto;

import java.util.Arrays;
import java.util.Map;

public class LottoResultView {
	public static void printStatistics(LottoResult result, int purchaseCount) {
        System.out.println("\n당첨 통계\n---");
        printWinningResults(result.getRankCounts());
        printProfitRate(purchaseCount, result.getRankCounts());
    }

    private static void printWinningResults(Map<WinningRank, Integer> rankCounts) {
        Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .forEach(rank -> printRankResult(rank, rankCounts.get(rank)));
    }

    private static void printRankResult(WinningRank rank, int count) {
        System.out.printf("%s (%,d원) - %d개\n", 
                rank.getDescription(), 
                rank.getPrize(), 
                count);
    }

    private static void printProfitRate(int purchaseCount, Map<WinningRank, Integer> rankCounts) {
        double profitRate = LottoProfitCalculator.calculate(purchaseCount, rankCounts);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

}

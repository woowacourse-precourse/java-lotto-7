package lotto;

import java.util.Map;
import java.util.stream.Stream;
import java.util.Comparator;

public class LottoResultPrinter {

    public static void printResults(Map<PrizeRank, Integer> resultCounts, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = calculateTotalPrize(resultCounts);
        printPrizeCounts(resultCounts);
        printYield(totalPrize, purchaseAmount);

    }

    private static void printPrizeCounts(Map<PrizeRank, Integer> resultCounts) {
        Stream.of(PrizeRank.values())
                .sorted(Comparator.comparingInt(PrizeRank::getMatchCount))
                .forEach(rank -> printRankCount(resultCounts, rank));
    }

    private static void printRankCount(Map<PrizeRank, Integer> resultCounts, PrizeRank rank) {
        int count = resultCounts.getOrDefault(rank, 0);
        if (rank == PrizeRank.SECOND) {
            System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", rank.getPrize(), count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), count);
    }

    private static int calculateTotalPrize(Map<PrizeRank, Integer> resultCounts) {
        int totalPrize = 0;
        for (PrizeRank rank : PrizeRank.values()) {
            int count = resultCounts.getOrDefault(rank, 0);
            totalPrize += count * rank.getPrize();
        }
        return totalPrize;
    }

    private static void printYield(int totalPrize, int totalAmountSpent) {
        if (totalAmountSpent == 0) {
            System.out.printf("총 수익률은 0.0%%입니다.\n");
            return;
        }

        double yield = (double) totalPrize / totalAmountSpent * 100;
        yield = Math.round(yield * 10) / 10.0; // 소수점 반올림
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }

    private static int calculateTotalAmountSpent(int purchaseAmount) {
        return purchaseAmount;
    }

}

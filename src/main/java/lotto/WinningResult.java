package lotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<LottoRank, Integer> rankCounts;

    public WinningResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addWinningRank(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public void printStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), rankCounts.get(rank));
            }
        }
    }

    public double calculateReturnRate(int purchaseAmount) {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += (long) rankCounts.get(rank) * rank.getPrize();
        }
        return (double) totalPrize * 100 / purchaseAmount;
    }
}
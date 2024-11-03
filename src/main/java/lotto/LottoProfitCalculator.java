package lotto;

import java.util.Map;
import java.util.stream.IntStream;

public class LottoProfitCalculator {
    private final Map<Integer, Integer> rankCounts;

    public LottoProfitCalculator(Map<Integer, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public double calculateProfitRate(int money) {
        long prize = sumOfPrize(rankCounts);
        return (double) prize / (double) money * 100.0;
    }

    private long sumOfPrize(Map<Integer, Integer> rankCounts) {
        return IntStream.rangeClosed(1, 5)
                .mapToLong(rank -> {
                    return getPrizeAsRank(rank) * rankCounts.getOrDefault(rank, 0);
                })
                .sum();

    }

    private long getPrizeAsRank(int rank) {
        if (rank == 1) {
            return LottoRank.FIRST.getPrize();
        }
        if (rank == 2) {
            return LottoRank.SECOND.getPrize();
        }
        if (rank == 3) {
            return LottoRank.THIRD.getPrize();
        }
        if (rank == 4) {
            return LottoRank.FOURTH.getPrize();
        }
        if (rank == 5) {
            return LottoRank.FIFTH.getPrize();
        }

        return 0;
    }
}

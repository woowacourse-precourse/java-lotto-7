package lotto.model;

import lotto.util.Validation;

public class LottoResult {
    private final int[] rankCounts; // 각 등수의 당첨 횟수 (index 0: 1등, index 1: 2등, ..., index 5: 꽝)

    public LottoResult() {
        rankCounts = new int[PrizeAmount.values().length];
    }

    // 각 등수 추가 메서드
    public void addWin(int rank) {
        Validation.validateRank(rank);
        rankCounts[rank - 1]++;
    }



    public long getTotalPrizeAmount() {
        long totalPrize = 0;

        for (int i = 0; i < rankCounts.length; i++) {
            totalPrize += (long) rankCounts[i] * PrizeAmount.values()[i].getPrizeAmount();
        }

        return totalPrize;
    }

    public int[] getRankCounts() {
        return rankCounts;
    }
}

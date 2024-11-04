package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistic {
    private final Map<WinningRank, Integer> rankCount;
    private final int totalPrice;

    public LottoStatistic(Lottos lottos, WinningLotto winningLotto, int totalPrice) {
        this.rankCount = initializeRankCount();
        calculateRank(lottos, winningLotto);
        this.totalPrice = totalPrice;
    }

    private Map<WinningRank, Integer> initializeRankCount() {
        Map<WinningRank, Integer> rankCount = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            rankCount.put(rank, 0);
        }
        return rankCount;
    }

    private void calculateRank(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            WinningRank rank = winningLotto.match(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
    }

    public Map<WinningRank, Integer> getRankCount() {
        return new HashMap<>(rankCount);
    }

    public double calculateProfitRate() {
        long totalPrize = 0;
        for (Map.Entry<WinningRank, Integer> entry : rankCount.entrySet()) {
            totalPrize += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return Math.round((totalPrize * 100.0 / totalPrice) * 10.0) / 10.0;
    }
}
package lotto.statistics;

import lotto.model.LottoRank;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoStatistics {

    private Map<LottoRank, Integer> statistics;

    public LottoStatistics() {
        statistics = new LinkedHashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }
    }

    public void incrementWinningCount(LottoRank lottoRank) {
        int currentWinningCount = statistics.get(lottoRank);
        statistics.put(lottoRank, currentWinningCount + 1);
    }

    public long calculatePrizeMoney() {
        long prizeMoney = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            long rankPrizeMoney = lottoRank.getPrizeMoney();
            int winningCount = statistics.get(lottoRank);

            prizeMoney += rankPrizeMoney * winningCount;
        }

        return prizeMoney;
    }

    public double calculateProfitMargin(int purchaseAmount, long prizeMoney) {
        return (double) prizeMoney / purchaseAmount * 100;
    }

    public int size() {
        return statistics.size();
    }

    public int getWinningCount(LottoRank lottoRank) {
        return statistics.get(lottoRank);
    }
}

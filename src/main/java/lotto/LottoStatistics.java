package lotto;

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
        int currentCount = statistics.get(lottoRank);
        statistics.put(lottoRank, currentCount + 1);
    }

    public String calculateProfitMargin(int purchaseAmount) {
        int prizeMoney = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            prizeMoney += lottoRank.getPrizeMoney() * statistics.get(lottoRank);
        }

        double profitMargin = (double) prizeMoney / purchaseAmount * 100;

        return String.format("%.1f", profitMargin);
    }

    public int size() {
        return statistics.size();
    }

    public int getWinningCount(LottoRank lottoRank) {
        return statistics.get(lottoRank);
    }
}

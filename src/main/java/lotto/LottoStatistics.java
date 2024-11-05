package lotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> statistics = new HashMap<>();
    private int totalCost;
    private int totalWinnings;

    public LottoStatistics() {
        for (LottoResult result : LottoResult.values()) {
            statistics.put(result, 0);
        }
        this.totalCost = 0;
        this.totalWinnings = 0;
    }

    public void recordWin(LottoResult result) {
        if (result != null) {
            statistics.put(result, statistics.get(result) + 1);
            totalWinnings += result.getPrize();
        }
    }

    public Map<LottoResult, Integer> getStatistics() {
        return statistics;
    }


    public void addCost(int cost) {
        totalCost += cost; // 로또 구매 비용 추가
    }

    public double calculateYield() {
        if (totalCost == 0) {
            return 0; // 총 비용이 0이면 수익률은 0%
        }
        double yield = ((double) totalWinnings)/ totalCost * 100; // 수익률 계산
        return yield;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }
}

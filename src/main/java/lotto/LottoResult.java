package lotto;

import java.util.Collections;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRanking, Integer> results;

    public LottoResult(Map<LottoRanking, Integer> results) {
        this.results = results;
    }

    public int getResultCount(LottoRanking ranking) {
        return results.getOrDefault(ranking, 0);
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (LottoRanking ranking : LottoRanking.values()) {
            totalPrize += results.getOrDefault(ranking,0) * ranking.getPrize();
        }
        return totalPrize;
    }

    public double calculateProfit(int spentCost) {
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / spentCost * 100;
    }
}

package lotto.service.calculate;

import lotto.model.Prize;
import lotto.model.PrizeRank;

import java.util.Map;

public class ProfitService {
    private final Map<PrizeRank, Prize> prizeMap;
    private final int totalCost;

    public ProfitService(Map<PrizeRank, Prize> prizeMap, int totalCost) {
        this.prizeMap = prizeMap;
        this.totalCost = totalCost;
    }

    // Calculate total profit based on prize winnings and cost
    public double calculateProfitRate() {
        int totalPrize = prizeMap.values().stream()
                .mapToInt(Prize::getTotalPrize)
                .sum();
        if (totalCost > 0) {
            return (double) totalPrize / totalCost;
        }
        return 0;
    }
}

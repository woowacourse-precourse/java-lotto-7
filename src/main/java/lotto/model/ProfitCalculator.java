package lotto.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoRank;

public class ProfitCalculator {
    public double getProfit(long purchaseAmount, Map<LottoRank, Integer> statistcs) {
        return getTotalPrize(statistcs).divide(new BigDecimal(purchaseAmount/100)).doubleValue();
    }

    private BigDecimal getTotalPrize(Map<LottoRank, Integer> statistcs) {
        BigDecimal totalPrize = new BigDecimal(0);
        for (Entry<LottoRank, Integer> status : statistcs.entrySet()) {
            totalPrize = totalPrize.add(new BigDecimal(status.getKey().getPrize()*status.getValue()));
        }
        return totalPrize;
    }
}

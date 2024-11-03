package lotto.domain.lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {

    private final Map<LottoRank, BigDecimal> result = new HashMap<>();

    public LottoResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, BigDecimal.ZERO);
        }
    }

    public BigDecimal calculateProfit() {
        BigDecimal profit = BigDecimal.ZERO;
        for (Entry<LottoRank, BigDecimal> entry : result.entrySet()) {
            profit = profit.add(entry.getKey().getAward().multiply(entry.getValue()));
        }
        return profit;
    }

    void add(LottoRank lottoRank) {
        result.put(lottoRank, result.get(lottoRank).add(BigDecimal.ONE));
    }

    public BigDecimal get(LottoRank lottoRank) {
        return result.get(lottoRank);
    }
}

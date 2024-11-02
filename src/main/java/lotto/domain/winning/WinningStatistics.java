package lotto.domain.winning;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<LottoRank, Integer> result = new HashMap<>();

    public WinningStatistics() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void addWinCountByRank(LottoRank lottoRank) {
        result.put(lottoRank, result.get(lottoRank) + 1);
    }

    public int getWinningCountByRank(LottoRank lottoRank) {
        return result.get(lottoRank);
    }

    public BigDecimal getTotalPrize() {
        BigDecimal total = BigDecimal.ZERO;
        for (LottoRank lottoRank : result.keySet()) {
            total = total.add(calculateTotalPrizeByRank(lottoRank));
        }
        return total;
    }

    private BigDecimal calculateTotalPrizeByRank(LottoRank lottoRank) {
        return BigDecimal.valueOf(lottoRank.getPrizeMoney())
                .multiply(BigDecimal.valueOf(getWinningCountByRank(lottoRank)));
    }

}

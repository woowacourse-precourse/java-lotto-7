package lotto.domain.winning;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<Rank, Integer> result = new HashMap<>();

    public WinningStatistics() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void addWinCountByRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getCountByRank(Rank rank) {
        return result.get(rank);
    }

    public BigDecimal getTotalPrize() {
        BigDecimal total = BigDecimal.ZERO;
        for (Rank rank : result.keySet()) {
            total = total.add(calculateTotalPrizeByRank(rank));
        }
        return total;
    }

    private BigDecimal calculateTotalPrizeByRank(Rank rank) {
        return BigDecimal.valueOf(rank.getPrizeMoney())
                .multiply(BigDecimal.valueOf(getCountByRank(rank)));
    }

}

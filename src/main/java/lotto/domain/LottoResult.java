package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult() {
        rankCounts = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRankCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public BigDecimal calculateTotalPrize() {
        return rankCounts.entrySet()
                         .stream()
                         .map(entry -> entry.getKey()
                                            .calculatePrizeByRankCount(entry.getValue()))
                         .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}

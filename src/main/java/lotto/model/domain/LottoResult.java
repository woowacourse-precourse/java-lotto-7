package lotto.model.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import lotto.config.LottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;
    // 각 등수가 몇번 당첨됬는지를 저장하는 map

    public LottoResult() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
    }

    public void addRank(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    //수익률 계산
    public double calculateProfitRate(int totalPurchaseAmount) {
        long totalPrize = Arrays.stream(LottoRank.values())
                .mapToLong(rank -> rank.getPrize() * rankCounts.get(rank))
                .sum();
        return (totalPrize * 100.0) / totalPurchaseAmount;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }
}
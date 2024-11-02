package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultRank;
    private final int purchasePrice;

    public LottoResult(int purchasePrice) {
        this.resultRank = new HashMap<>();
        this.purchasePrice = purchasePrice;
    }

    public void addRank(LottoRank lottoRank) {
        resultRank.put(lottoRank, resultRank.getOrDefault(lottoRank, 0) + 1);
    }

    public int getRankCount(LottoRank lottoRank) {
        return resultRank.getOrDefault(lottoRank, 0);
    }

    public double calculateProfitRate() {
        Long totalPrize = resultRank.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();

        return (double) totalPrize / purchasePrice * 100;
    }
}

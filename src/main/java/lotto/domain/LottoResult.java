package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public long count(Rank rank) {
        return ranks.stream()
                .filter(r -> r == rank)
                .count();
    }

    public double calculateProfitRate(int money) {
        int totalPrize = ranks.stream()
                .mapToInt(Rank::getPrize)
                .sum();
        return (totalPrize / (double) money) * 100;
    }
}

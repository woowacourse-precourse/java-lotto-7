package lotto.Model;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;

    public LottoResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = ranks.stream().mapToInt(Rank::getPrize).sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}

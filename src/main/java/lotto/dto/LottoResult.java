package lotto.dto;

public class LottoResult {
    private final RankCounts rankCounts;
    private final int purchaseAmount;

    public LottoResult(RankCounts rankCounts, int purchaseAmount) {
        this.rankCounts = rankCounts;
        this.purchaseAmount = purchaseAmount;
    }

    public RankCounts getRankCounts() {
        return rankCounts;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}

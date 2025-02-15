package lotto.model;

public class LottoResult {
    private static final Integer PERCENT=100;
    private final int totalSpent;
    private final int[] rankCounts;

    public LottoResult(int totalSpent, int[] rankCounts) {
        this.totalSpent = totalSpent;
        this.rankCounts = rankCounts;
    }

    public int getCount(Rank rank) {
       return rankCounts[rank.getIndex()];
    }

    public double calculateYield() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += getCount(rank) * rank.getPrize();
        }
        return (double) totalPrize / totalSpent * PERCENT;
    }
}

package lotto.model;

public class LottoResult {
    private final int totalSpent;
    private final int[] rankCounts;

    public LottoResult(int totalSpent, int[] rankCounts) {
        this.totalSpent = totalSpent;
        this.rankCounts = rankCounts;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public int getCount(Rank rank) {
        switch (rank) {
            case FIFTH: return rankCounts[0];
            case FOURTH: return rankCounts[1];
            case THIRD: return rankCounts[2];
            case SECOND: return rankCounts[3];
            case FIRST: return rankCounts[4];
            default: return 0;
        }
    }

    public double calculateYield() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += getCount(rank) * rank.getPrize();
        }
        return (double) totalPrize / totalSpent * 100;
    }
}

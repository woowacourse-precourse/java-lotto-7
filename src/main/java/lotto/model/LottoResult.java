package lotto.model;

public class LottoResult {
    private final int totalSpent; // 총 구매 금액
    private final int[] rankCounts; // 각 등수별 통계

    public LottoResult(int totalSpent, int[] rankCounts) {
        this.totalSpent = totalSpent;
        this.rankCounts = rankCounts;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public int getCount(Rank rank) {
        switch (rank) {
            case FIFTH: return rankCounts[0]; // 3개 일치
            case FOURTH: return rankCounts[1]; // 4개 일치
            case THIRD: return rankCounts[2]; // 5개 일치
            case SECOND: return rankCounts[3]; // 5개 + 보너스
            case FIRST: return rankCounts[4]; // 6개 일치
            default: return 0;
        }
    }

    public double calculateYield() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += getCount(rank) * rank.getPrize();
        }
        return (double) totalPrize / totalSpent * 100; // 수익률 계산
    }
}

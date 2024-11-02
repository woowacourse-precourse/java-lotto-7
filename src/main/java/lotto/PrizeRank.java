package lotto;

public enum PrizeRank {
    FIRST("1등", 6, 2_000_000_000),
    SECOND("2등", 5, 30_000_000),
    THIRD("3등", 5, 1_500_000),
    FOURTH("4등", 4, 50_000),
    FIFTH("5등", 3, 5_000);

    private final String label;
    private final int matchCount;
    private final int prize;

    PrizeRank(String label, int matchCount, int prize) {
        this.label = label;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getLabel() {
        return label;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}

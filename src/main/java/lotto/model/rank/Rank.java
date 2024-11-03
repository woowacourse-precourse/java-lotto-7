package lotto.model.rank;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchingCount;
    private final int prize;
    private final boolean hasBonus;

    Rank(int matchingCount, int prize, boolean hasBonus) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

}

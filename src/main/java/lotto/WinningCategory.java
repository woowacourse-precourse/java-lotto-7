package lotto;

public enum WinningCategory {
    SIX_MATCH(6, false, 2_000_000_000),
    FIVE_MATCH_WITH_BONUS(5, true, 30_000_000),
    FIVE_MATCH(5, false, 1_500_000),
    FOUR_MATCH(4, false, 50_000),
    THREE_MATCH(3, false, 5_000),
    NO_WIN(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    WinningCategory(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int getPrize() {
        return prize;
    }
}

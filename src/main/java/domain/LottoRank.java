package domain;

public enum LottoRank {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank of(int matchCount, boolean hasBonus) {
        if (matchCount == SIX) return SIX;
        if (matchCount == FIVE) return hasBonus ? FIVE_WITH_BONUS : FIVE;
        if (matchCount == FOUR) return FOUR;
        if (matchCount == THREE) return THREE;
        return NONE;
    }
}

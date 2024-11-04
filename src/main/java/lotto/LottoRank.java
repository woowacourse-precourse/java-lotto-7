package lotto;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    LottoRank(int matchCount, boolean hasBonus, int prize) {
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

    public long getPrize() {
        return prize;
    }

}
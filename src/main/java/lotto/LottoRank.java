package lotto;

public enum LottoRank {
    FIFTH(3, false, 5_000, 1),
    FOURTH(4, false, 50_000, 2),
    THIRD(5, false, 1_500_000, 3),
    SECOND(5, true, 30_000_000, 4),
    FIRST(6, false, 2_000_000_000, 5),
    NONE(0, false, 0, 6);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;
    private final int order;

    LottoRank(int matchCount, boolean hasBonus, int prize, int order) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.order = order;
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

    public int getOrder() {
        return order;
    }

}
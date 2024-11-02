package lotto;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(4, false, 1500000),
    FOURTH(3, false, 50000),
    FIFTH(2, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requriesBonus;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonus,int prize) {
        this.matchCount = matchCount;
        this.requriesBonus = requiresBonus;
        this.prize = prize;
    }

    public static LottoRank getRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean requiresBonus() {
        return requriesBonus;
    }

    public int getPrize() {
        return prize;
    }
}

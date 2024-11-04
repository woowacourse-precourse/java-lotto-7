package lotto.model;

public enum LottoRank {
    FIRST(6, "2,000,000,000", false),
    SECOND(5, "30,000,000", true),
    THIRD(5, "1,500,000", false),
    FOURTH(4, "50,000", false),
    FIFTH(3, "5,000", false);

    private final int matchCount;
    private final String prize;
    private final boolean bonus;

    LottoRank(int matchCount, String prize, boolean bonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getPrize() {
        return prize;
    }

    public boolean isMatchBonus() {
        return bonus;
    }

    public static LottoRank valueOf(int matchCount, boolean bonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return null;
    }
}

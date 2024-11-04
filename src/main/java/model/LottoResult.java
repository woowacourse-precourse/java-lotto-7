package model;

public enum LottoResult {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoResult(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoResult getResultForMatchAndBonus(int matchCount, boolean bonusMatch) {
        for (LottoResult result : values()) {
            if (result.matchCount == matchCount && result.bonusMatch == bonusMatch) {
                return result;
            }
        }
        return NONE;
    }
}

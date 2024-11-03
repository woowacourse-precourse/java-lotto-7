package lotto.model;

public enum LottoResult {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    LottoResult(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoResult getLottoResult(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return SIX;
        } else if (matchCount == 5 && hasBonus) {
            return FIVE_BONUS;
        } else if (matchCount == 5) {
            return FIVE;
        } else if (matchCount == 4) {
            return FOUR;
        } else if (matchCount == 3) {
            return THREE;
        }
        return null;
    }
}

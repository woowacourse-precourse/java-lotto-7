package lotto.utils;

public enum Prize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_AND_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int matchAmount;

    Prize(int matchCount, int matchAmount) {
        this.matchCount = matchCount;
        this.matchAmount = matchAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public static Prize match(int matchCount, boolean withBonus) {
        if (matchCount == 3) return THREE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 5 && withBonus) return FIVE_AND_BONUS;
        if (matchCount == 5) return FIVE;
        if (matchCount == 6) return SIX;

        return null;
    }

}

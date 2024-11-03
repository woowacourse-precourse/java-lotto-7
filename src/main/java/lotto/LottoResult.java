package lotto;

public enum LottoResult {
    SIX(6, 0),
    FIVE_WITH_BONUS(5, 1),
    FIVE(5, 0),
    FOUR(4, 0),
    THREE(3, 0),
    NONE(0, 0);

    private final Integer defaultMatchCount;
    private final Integer bonusMatchCount;

    LottoResult(Integer defaultMatchCount, Integer bonusMatchCount) {
        this.defaultMatchCount = defaultMatchCount;
        this.bonusMatchCount = bonusMatchCount;
    }

    public static LottoResult fromMatchCounts(Integer defaultMatchCount, Integer bonusMatchCount) {
        for (LottoResult result : LottoResult.values()) {
            if (result.defaultMatchCount.equals(defaultMatchCount) && result.bonusMatchCount.equals(bonusMatchCount))
                return result;
        }
        return NONE;
    }

    public Integer getWinningMoney() {
        if (this == SIX)
            return 2000000000;

        if (this == FIVE_WITH_BONUS)
            return 30000000;

        if (this == FIVE)
            return 1500000;

        if (this == FOUR)
            return 50000;

        if (this == THREE)
            return 5000;

        return 0;
    }
}

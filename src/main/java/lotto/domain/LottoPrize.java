package lotto.domain;

public enum LottoPrize {
    NOTHING(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int money;
    private final int matchCount;
    private final boolean isBonusNumberMatched;

    LottoPrize(int money, int matchCount, boolean isBonusNumberMatched) {
        this.money = money;
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }

    public static LottoPrize valueOf(int matchCount, boolean isBonusMatched) {
        if (matchCount == SECOND.matchCount && isBonusMatched == SECOND.isBonusNumberMatched) {
            return SECOND;
        }
        for (LottoPrize lottoPrize : values()) {
            if (matchCount == lottoPrize.matchCount && lottoPrize != SECOND) {
                return lottoPrize;
            }
        }

        return NOTHING;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean doesBonusNumberMatters() {
        return isBonusNumberMatched;
    }
}

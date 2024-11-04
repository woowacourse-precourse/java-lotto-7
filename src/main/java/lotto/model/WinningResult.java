package lotto.model;

public enum WinningResult {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int normalCount;
    private final boolean bonusMatch;
    private final int reward;

    WinningResult(int normalCount, boolean bonusCount, int reward) {
        this.normalCount = normalCount;
        this.bonusMatch = bonusCount;
        this.reward = reward;
    }

    public static WinningResult of(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }

        for (WinningResult result : values()) {
            if (result.normalCount == matchCount) {
                return result;
            }
        }
        return NONE;
    }

    public int getNormalCount() {
        return normalCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getReward() {
        return reward;
    }
}

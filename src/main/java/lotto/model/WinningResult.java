package lotto.model;

public enum WinningResult {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0, 0, 0);

    private final int normalCount;
    private final int bonusCount;
    private final int reward;


    WinningResult(int normalCount, int bonusCount, int reward) {
        this.normalCount = normalCount;
        this.bonusCount = bonusCount;
        this.reward = reward;
    }

    public static WinningResult of(int normalCount, int bonusCount) {
        for (WinningResult winningResult : values()) {
            if (winningResult.normalCount == normalCount && winningResult.bonusCount == bonusCount) {
                return winningResult;
            }
        }
        return NONE;
    }

    public int getReward() {
        return reward;
    }
}

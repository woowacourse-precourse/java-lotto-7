package lotto;

public enum Prize {
    FIRST(3, 5_000),
    SECOND(4, 50_000),
    THIRD(5, 1_500_000),
    FOURTH(5, 30_000_000),
    FIFTH(6, 2_000_000_000);

    private final int matchCount;
    private final int reward;

    Prize(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}

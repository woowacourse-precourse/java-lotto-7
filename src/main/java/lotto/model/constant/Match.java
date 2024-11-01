package lotto.model.constant;

public enum Match {
    THREE(3, "5,000원"),
    FOUR(4, "50,000원"),
    FIVE(5, "1,500,000원"),
    BONUS(5, "30,000,000원"),
    SIX(6, "2,000,000,000원");

    private final int matchCount;
    private final String reward;

    Match(int matchCount, String reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getReward() {
        return reward;
    }
}
package lotto;

public enum RewardTable {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_MATCHES_PLUS_BONUS(6, 30000000),
    SIX_MATCHES(7, 2000000000);

    private final int matches;
    private final int rewardAmount;

    RewardTable(int matches, int rewardAmount) {
        this.matches = matches;
        this.rewardAmount = rewardAmount;
    }

    public int getMatches() {
        return matches;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }
}

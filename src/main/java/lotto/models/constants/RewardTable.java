package lotto.models.constants;

public enum RewardTable {
    THREE_MATCHES(3, 5000, "3개 일치 (5,000원) - "),
    FOUR_MATCHES(4, 50000, "4개 일치 (50,000원) - "),
    FIVE_MATCHES(5, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_MATCHES_PLUS_BONUS(6, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCHES(7, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matches;
    private final int rewardAmount;
    private final String label;

    RewardTable(int matches, int rewardAmount, String label) {
        this.matches = matches;
        this.rewardAmount = rewardAmount;
        this.label = label;
    }

    public int getMatches() {
        return matches;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public String getLabel() {
        return label;
    }
}

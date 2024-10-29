package lotto;

public enum Prize {
    FIRST(2_000_000_000, "6개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000, "5개 일치"),
    FOURTH(50_000, "4개 일치"),
    FIFTH(5_000, "3개 일치");

    private final int rewards;
    private final String description;

    Prize(int rewards, String description) {
        this.rewards = rewards;
        this.description = description;
    }

    public int getRewards() {
        return rewards;
    }

    public String getDescription() {
        return description;
    }
}

package lotto.model;

public enum Prize {

    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int hitCount;
    private final int reward;

    Prize(int hitCount, int reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getReward() {
        return reward;
    }
}

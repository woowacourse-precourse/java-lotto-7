package lotto;

public enum Winning {
    FIRST(3, 5_000),
    SECOND(4, 50_000),
    THIRD(5, 1_500_000),
    FOURTH(5, 30_000_000),
    FIFTH(6, 2_000_000_000);

    private final int count;
    private final int reward;

    Winning(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }
}
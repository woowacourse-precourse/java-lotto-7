package lotto.model;

public enum Rank {
    SIX(6, false, 2000000000),
    FIVE_BONUS(5, true, 30000000),
    FIVE(5, false, 1500000),
    FOUR(4, false, 50000),
    THREE(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int reward;

    Rank(int matchCount, boolean requiresBonus, int reward) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return SIX;
        }
        if (matchCount == 5 && matchBonus) {
            return FIVE_BONUS;
        }
        if (matchCount == 5) {
            return FIVE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 3) {
            return THREE;
        }
        return NONE;
    }
}

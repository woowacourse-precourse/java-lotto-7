package lotto;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false,1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int reward;

    Rank(int matchCount, boolean requiresBonus, int reward) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == hasBonus) {
                return rank;
            }
        }
        return NONE;
    }
}

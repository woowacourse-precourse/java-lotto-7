package lotto.model;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean requiresBonus;

    Rank(int matchCount, int reward, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.requiresBonus = requiresBonus;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.requiresBonus || matchBonus == rank.requiresBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}
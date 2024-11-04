package lotto.enums;

public enum LottoRank {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int reward;

    LottoRank(int matchingCount, boolean matchBonus, int reward) {
        this.matchCount = matchingCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getReward() {
        return reward;
    }

}

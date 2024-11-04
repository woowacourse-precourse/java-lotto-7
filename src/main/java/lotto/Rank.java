package lotto;

import java.util.List;

public enum Rank {
    FIRST(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD(5, false, "5개 일치 (1,500,000원)", 1_500_000),
    FOURTH(4, false, "4개 일치 (50,000원)", 50_000),
    FIFTH(3, false, "3개 일치 (5,000원)", 5_000),
    NONE(0, false, "당첨되지 않음", 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final String result;
    private final int reward;

    Rank(int matchCount, boolean matchBonus, String result, int reward) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.result = result;
        this.reward = reward;
    }

    public String getResult() {
        return result;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }
}

package lotto.utils;

import java.util.Arrays;

public enum Reward {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NO_REWARD(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    Reward(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Reward getReward(int matchedCount, boolean hasBonus) {
        return Arrays
                .stream(values())
                .filter(reward -> reward.matchCount == matchedCount && reward.hasBonus == hasBonus)
                .findAny()
                .orElseGet(() -> NO_REWARD);
    }

    public int getPrize() {
        return prize;
    }
}


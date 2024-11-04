package lotto.utils;

import java.util.Arrays;

public enum Reward {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - "),
    NO_REWARD(0, false, 0, "");

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;
    private final String description;

    Reward(int matchCount, boolean hasBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.description = description;
    }

    public static Reward forMatch(int matchedCount, boolean hasBonus) {
        return Arrays
                .stream(values())
                .filter(reward -> reward.isMatchCountAndHasBonus(matchedCount, hasBonus))
                .findAny()
                .orElseGet(() -> NO_REWARD);
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    private boolean isMatchCountAndHasBonus(int matchCount, boolean hasBonus) {
        if (this.matchCount == 5) {
            return this.matchCount == matchCount && this.hasBonus == hasBonus;
        }

        return this.matchCount == matchCount;
    }
}


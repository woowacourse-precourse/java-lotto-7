package lotto.enums;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    ;

    private final int matchCount;
    private final int prizeAmount;
    private final boolean requiresBonus;

    Prize(int matchCount, int prizeAmount, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean getRequiresBonus() {
        return requiresBonus;
    }

    public static Prize findPrize(int matchingCount, boolean requiresBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchingCount
                        && (!prize.requiresBonus || requiresBonus == prize.requiresBonus))
                .findFirst().get();
        }
}

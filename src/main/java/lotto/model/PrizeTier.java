package lotto.model;

import java.util.Arrays;

public enum PrizeTier {
    NO_PRIZE(0, false, 0),
    MATCH_THREE(3, false, 5_000),
    MATCH_FOUR(4, false, 50_000),
    MATCH_FIVE(5, false, 1_500_000),
    MATCH_FIVE_WITH_BONUS(5, true, 30_000_000),
    MATCH_SIX(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean requiresBonusMatch;
    private final int prizeAmount;

    PrizeTier(int matchCount, boolean requiresBonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    private boolean matches(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount && this.requiresBonusMatch == bonusMatch;
    }

    public static PrizeTier findPrize(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(tier -> tier.matches(matchCount, bonusMatch))
                .findFirst()
                .orElse(NO_PRIZE);
    }

}

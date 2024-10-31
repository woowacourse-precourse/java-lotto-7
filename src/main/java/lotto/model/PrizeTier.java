package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum PrizeTier {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeAmount;

    PrizeTier(int matchCount, boolean bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static Optional<PrizeTier> findPrize(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(tier -> tier.matchCount == matchCount && tier.bonusMatch == bonusMatch)
                .findFirst();
    }

}

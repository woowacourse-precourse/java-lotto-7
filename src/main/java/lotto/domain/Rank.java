package lotto.domain;

import java.math.BigInteger;

public enum Rank {
    FIRST(6, false, BigInteger.valueOf(2_000_000_000)),
    SECOND(5, true, BigInteger.valueOf(30_000_000)),
    THIRD(5, false, BigInteger.valueOf(1_500_000)),
    FOURTH(4, false, BigInteger.valueOf(50_000)),
    FIFTH(3, false, BigInteger.valueOf(5_000)),
    NONE(-1, false, BigInteger.ZERO);

    private final int matchingCount;
    private final boolean onlyHasBonus;
    private final BigInteger prizeAmount;

    Rank(int matchingCount, boolean onlySuccessBonus, BigInteger prizeAmount) {
        this.matchingCount = matchingCount;
        this.onlyHasBonus = onlySuccessBonus;
        this.prizeAmount = prizeAmount;
    }

    public static Rank with(int matchingCount, boolean successBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount(matchingCount) && rank.matchBonus(successBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean matchCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    private boolean matchBonus(boolean hasBonus) {
        return !this.onlyHasBonus || hasBonus;
    }

    public BigInteger getPrizeAmount() {
        return this.prizeAmount;
    }

    public boolean isPrizeRank() {
        return this != NONE;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public BigInteger prizeAmount() {
        return this.prizeAmount;
    }

    public boolean shouldSuccessBonus() {
        return this.onlyHasBonus;
    }

}

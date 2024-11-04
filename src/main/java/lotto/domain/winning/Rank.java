package lotto.domain.winning;

import java.math.BigInteger;

public enum Rank {
    FIRST(6, BigInteger.valueOf(2_000_000_000)),
    SECOND(5, BigInteger.valueOf(30_000_000), true),
    THIRD(5, BigInteger.valueOf(1_500_000)),
    FOURTH(4, BigInteger.valueOf(50_000)),
    FIFTH(3, BigInteger.valueOf(5_000)),
    MISS(0, BigInteger.ZERO);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final BigInteger prize;

    Rank(int matchCount, BigInteger prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonusNumber = false;
    }

    Rank(int matchCount, BigInteger prize, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank of(int matchCount, boolean hasBonusNumber) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        } else if (matchCount == SECOND.matchCount && hasBonusNumber) {
            return SECOND;
        } else if (matchCount == THIRD.matchCount) {
            return THIRD;
        } else if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        } else if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }

        return MISS;
    }

    public BigInteger getPrize() {
        return prize;
    }
}

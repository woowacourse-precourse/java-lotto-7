package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    NO_RANK(0, 0L, false)
    ;

    private final long matchCount;
    private final long prizeMoney;
    private final boolean isBonusNumber;

    LottoRank(long matchCount, long prizeMoney, boolean isBonusNumber) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonusNumber = isBonusNumber;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public static LottoRank valueOf(long matchCount, boolean isBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, isBonusNumber))
                .findFirst()
                .orElse(NO_RANK);
    }

    private boolean matches(long matchCount, boolean isBonusNumber) {
        return this.matchCount == matchCount && this.isBonusNumber == isBonusNumber;
    }
}

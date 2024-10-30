package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NO_RANK(0, false, 0L)
    ;

    private final long matchCount;
    private final boolean isBonusNumber;
    private final long money;

    LottoRank(long matchCount, boolean isBonusNumber, long money) {
        this.matchCount = matchCount;
        this.isBonusNumber = isBonusNumber;
        this.money = money;
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

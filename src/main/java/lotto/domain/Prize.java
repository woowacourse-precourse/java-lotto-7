package lotto.domain;

import java.util.Arrays;

import static lotto.domain.Prize.BonusNumberStatus.*;

public enum Prize {
    NONE(0, 0, EXCLUDE),
    FIFTH(3, 5_000, OPTIONAL),
    FOURTH(4, 50_000, OPTIONAL),
    THIRD(5, 1_500_000, EXCLUDE),
    SECOND(5, 30_000_000, INCLUDE),
    FIRST(6, 2_000_000_000, OPTIONAL);

    private final int matchingNumberCount;
    private final int prizeMoney;
    private final BonusNumberStatus bonusNumberStatus;

    Prize(int matchingNumberCount, int prizeMoney, BonusNumberStatus bonusNumberStatus) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
        this.bonusNumberStatus = bonusNumberStatus;
    }

    public static Prize of(int matchingNumberCount, boolean containsBonusNumber) {
        if (matchingNumberCount == SECOND.matchingNumberCount && containsBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchingNumberCount == matchingNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public enum BonusNumberStatus {
        INCLUDE,
        EXCLUDE,
        OPTIONAL
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public BonusNumberStatus getBonusNumberStatus() {
        return bonusNumberStatus;
    }
}

package lotto.domain;

import java.util.Arrays;

import static lotto.domain.Prize.BonusNumberStatus.*;

public enum Prize {
    NONE(0, 0, UNDEFINED),
    FIFTH(3, 5_000, UNDEFINED),
    FOURTH(4, 50_000, UNDEFINED),
    THIRD(5, 1_500_000, EXCLUDE_BONUS),
    SECOND(5, 30_000_000, INCLUDE_BONUS),
    FIRST(6, 2_000_000_000, UNDEFINED);

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
        INCLUDE_BONUS,
        EXCLUDE_BONUS,
        UNDEFINED  // 상태가 명확하지 않을 때 사용
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

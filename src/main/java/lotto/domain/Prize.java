package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    EMPTY(0, 0, (matchCount, containsBonusNumber) -> matchCount < 3),
    THREE_MATCH(5_000, 3, (matchCount, containBonusNumber) -> matchCount == 3),
    FOUR_MATCH(50_000, 4, (matchCount, containBonusNumber) -> matchCount == 4),
    FIVE_MATCH_WITHOUT_BONUS_BALL(1_500_000, 5,
            (matchCount, containBonusNumber) -> matchCount == 5 && !containBonusNumber),
    FIVE_MATCH_WITH_BONUS_BALL(30_000_000, 5,
            (matchCount, containBonusNumber) -> matchCount == 5 && containBonusNumber),
    SIX_MATCH(2_000_000_000, 6, (matchCount, containBonusNumber) -> matchCount == 6);

    private final int prizeMoney;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> isWinningCondition;

    Prize(int prizeMoney, int matchCount, BiPredicate<Integer, Boolean> isWinningCondition) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.isWinningCondition = isWinningCondition;
    }

    public static Prize determinePrize(int matchCount, boolean containsBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isWinningCondition.test(matchCount, containsBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }
}

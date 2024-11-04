package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static lotto.common.Constants.*;
import static lotto.common.ValidationUtils.validateInRange;

public enum LottoRank {
    UN_RANK(0, 0,
            (matchCount, isBonus) -> matchCount < 3),
    MATCH_3_NUMBERS(3, 5000,
            (matchCount, isBonus) -> matchCount == 3),
    MATCH_4_NUMBERS(4, 50000,
            (matchCount, isBonus) -> matchCount == 4),
    MATCH_5_NUMBERS(5, 1500000,
            (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    MATCH_5_NUMBERS_WITH_BONUS_NUMBER(5, 30000000,
            (matchCount, isBonus) -> matchCount == 5 && isBonus),
    MATCH_6_NUMBERS(6, 2000000000,
            (matchCount, isBonus) -> matchCount == 6);

    private final Integer matchCount;
    private final Integer prizeMoney;
    private final BiPredicate<Integer, Boolean> condition;

    LottoRank(Integer matchCount, Integer prizeMoney, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.condition = condition;
    }

    public static LottoRank findRank(Integer matchCount, boolean bonusMatch) {
        validateInRange(String.valueOf(matchCount), MIN_MATCH_COUNT, MAX_MATCH_COUNT, INVALID_MATCH_COUNT);

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.test(matchCount, bonusMatch))
                .findAny()
                .orElse(UN_RANK);
    }

    private boolean test(Integer matchCount, boolean bonusMatch) {
        return condition.test(matchCount, bonusMatch);
    }
}
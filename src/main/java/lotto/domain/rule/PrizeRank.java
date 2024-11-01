package lotto.domain.rule;

import java.util.Arrays;
import java.util.function.Function;

public enum PrizeRank {
    FIRST(2000000000, match -> match == 6, false),
    SECOND(30000000, match -> match == 5, true),
    THIRD(1500000, match -> match == 5, false),
    FOURTH(50000, match -> match == 4, false),
    FIFTH(5000, match -> match == 3, false),
    LOSE(0, match -> match < 3, false);

    private final int prize;
    private final Function<Integer, Boolean> matchCondition;
    private final boolean requireBonus;

    PrizeRank(int prize, Function<Integer, Boolean> matchCondition, boolean requireBonus) {
        this.prize = prize;
        this.matchCondition = matchCondition;
        this.requireBonus = requireBonus;
    }

    public static PrizeRank find(int matchCount, boolean hasBonus) {
        return Arrays.stream(PrizeRank.values())
                .filter(prizeEnum -> isMatchConditionSatisfied(matchCount, prizeEnum))
                .filter(prizeEnum -> isBonusConditionSatisfied(hasBonus, prizeEnum))
                .findFirst()
                .orElse(LOSE);
    }

    private static Boolean isMatchConditionSatisfied(int matchCount, PrizeRank prizeRank) {
        return prizeRank.matchCondition.apply(matchCount);
    }

    private static boolean isBonusConditionSatisfied(boolean hasBonus, PrizeRank prizeRank) {
        return hasBonus == (prizeRank.requireBonus || hasBonus);
    }

    public int getPrize() {
        return prize;
    }
}

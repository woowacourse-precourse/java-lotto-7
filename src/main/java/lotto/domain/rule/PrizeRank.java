package lotto.domain.rule;

import java.util.Arrays;
import java.util.function.Function;

public enum PrizeRank {
    FIRST(2000000000, match -> match == 6, false, "6개 일치"),
    SECOND(30000000, match -> match == 5, true, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, match -> match == 5, false, "5개 일치"),
    FOURTH(50000, match -> match == 4, false, "4개 일치"),
    FIFTH(5000, match -> match == 3, false, "3개 일치"),
    LOSE(0, match -> match < 3, false, "꽝");

    private final int prize;
    private final Function<Integer, Boolean> matchCondition;
    private final boolean requireBonus;
    private final String description;

    PrizeRank(int prize, Function<Integer, Boolean> matchCondition, boolean requireBonus, String description) {
        this.prize = prize;
        this.matchCondition = matchCondition;
        this.requireBonus = requireBonus;
        this.description = description;
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

    public String getDescription() {
        return description;
    }
}

package lotto.model.rank;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum RankCondition {

    FIRST(6, (count, bonus) -> count == 6 && !bonus),
    SECOND(5, (count, bonus) -> count == 5 && bonus),
    THIRD(5, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, (count, bonus) -> count == 4 && !bonus),
    FIFTH(3, (count, bonus) -> count == 3 && !bonus),
    NONE(0, (count, bonus) -> count == 6 && !bonus);

    private final Integer matchedCount;
    private final BiPredicate<Integer, Boolean> predicate;

    RankCondition(final Integer matchedCount, final BiPredicate<Integer, Boolean> predicate) {
        this.matchedCount = matchedCount;
        this.predicate = predicate;
    }

    public static RankCondition getRankBy(int matchedCount, boolean bonusNumberMatched) {
        return Arrays.stream(RankCondition.values())
                .filter(rank -> rank.predicate.test(matchedCount, bonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }

    public static boolean enoughCountToBeSecondRank(int matchedCount) {
        return SECOND.matchedCount == matchedCount;
    }
}

package lotto.model.rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.function.BiPredicate;

public enum RankCondition {

    FIRST(1, 6, (count, bonus) -> count == 6 && !bonus),
    SECOND(2, 5, (count, bonus) -> count == 5 && bonus),
    THIRD(3, 5, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, 4, (count, bonus) -> count == 4 && !bonus),
    FIFTH(5, 3, (count, bonus) -> count == 3 && !bonus),
    NONE(6, 0, (count, bonus) -> count == 6 && !bonus);

    private final int rankPlace;
    private final Integer matchingCount;
    private final BiPredicate<Integer, Boolean> predicate;

    RankCondition(final int rankPlace, final Integer matchingCount, final BiPredicate<Integer, Boolean> predicate) {
        this.rankPlace = rankPlace;
        this.matchingCount = matchingCount;
        this.predicate = predicate;
    }

    public static RankCondition getRankBy(int matchingCount, boolean bonusNumberMatched) {
        return Arrays.stream(RankCondition.values())
                .filter(rank -> rank.predicate.test(matchingCount, bonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }

    public static boolean hasEnoughCountToBeSecondRank(int matchingCount) {
        return SECOND.matchingCount == matchingCount;
    }

    public static List<RankCondition> sortedValuesExceptNone() {
        Comparator<RankCondition> sortingCondition = Comparator.comparing(RankCondition::getRankPlace)
                .reversed();
        return Arrays.stream(RankCondition.values())
                .filter(RankCondition::exceptNone)
                .sorted(sortingCondition)
                .toList();
    }

    private int getRankPlace() {
        return this.rankPlace;
    }

    private static boolean exceptNone(RankCondition rankCondition) {
        return rankCondition != NONE;
    }

    public static EnumMap<RankCondition, String> stringMessageEnumMap() {
        EnumMap<RankCondition, String> rankEnumMap = new EnumMap<>(RankCondition.class);
        for (RankCondition condition : RankCondition.values()) {
            rankEnumMap.put(condition, condition.toStringMessage(condition));
        }
        return rankEnumMap;
    }

    public String toStringMessage(RankCondition condition) {
        if (condition == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치", matchingCount);
        }
        return String.format("%d개 일치", matchingCount);
    }
}

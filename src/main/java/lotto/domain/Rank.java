package lotto.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(2_000_000_000L, 6, (count, containsBonus) -> count == 6),
    SECOND(30_000_000L, 5, (count, containsBonus) -> count == 5 && containsBonus),
    THIRD(1_500_000L, 5, (count, containsBonus) -> count == 5 && !containsBonus),
    FOURTH(50_000L, 4, (count, containsBonus) -> count == 4),
    FIFTH(5_000L, 3, (count, containsBonus) -> count == 3),
    BLANK(0L, 0, (count, containsBonus) -> count < 3);

    final Long prize;
    final Integer matchedCount;
    private final BiPredicate<Long, Boolean> matchCondition;

    Rank(Long prize, Integer matchedCount, BiPredicate<Long, Boolean> matchCondition) {
        this.prize = prize;
        this.matchedCount = matchedCount;
        this.matchCondition = matchCondition;
    }

    public boolean matches(long count, boolean hasBonus) {
        return matchCondition.test(count, hasBonus);
    }

    public static Map<Rank, BigInteger> createCounts() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(rank -> rank, rank -> BigInteger.ZERO, (a, b) -> b));
    }

    public Long prize() {
        return prize;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

}

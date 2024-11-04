package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {

    FIFTH(3, 5_000, (count, matchesBonus) -> count == 3),
    FOURTH(4, 50_000, (count, matchesBonus) -> count == 4),
    THIRD(5, 1_500_000, (count, matchesBonus) -> count == 5 && !matchesBonus),
    SECOND(5, 30_000_000, (count, matchesBonus) -> count == 5 && matchesBonus),
    FIRST(6, 2_000_000_000, (count, matchesBonus) -> count == 6),
    NO_PRIZE(0, 0, (count, matchesBonus) -> count < 3);

    private final int matchingCount;
    private final int money;
    private final BiPredicate<Integer, Boolean> condition;

    Prize(int matchingCount, int money, BiPredicate<Integer, Boolean> condition) {
        this.matchingCount = matchingCount;
        this.money = money;
        this.condition = condition;
    }

    public static Prize findPrize(int matchingCount, boolean matchesBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.condition.test(matchingCount, matchesBonus))
                .findAny()
                .get();
    }
}

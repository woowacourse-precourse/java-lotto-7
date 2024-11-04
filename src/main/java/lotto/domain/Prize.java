package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {

    FIFTH(3, 5_000, (count, matchesBonus) -> count == 3, false),
    FOURTH(4, 50_000, (count, matchesBonus) -> count == 4, false),
    THIRD(5, 1_500_000, (count, matchesBonus) -> count == 5 && !matchesBonus, false),
    SECOND(5, 30_000_000, (count, matchesBonus) -> count == 5 && matchesBonus, true),
    FIRST(6, 2_000_000_000, (count, matchesBonus) -> count == 6, false),
    NO_PRIZE(0, 0, (count, matchesBonus) -> count < 3, false);

    private final int matchingCount;
    private final int money;
    private final BiPredicate<Integer, Boolean> condition;
    private final boolean matchBonus;

    Prize(int matchingCount, int money, BiPredicate<Integer, Boolean> condition, boolean matchBonus) {
        this.matchingCount = matchingCount;
        this.money = money;
        this.matchBonus = matchBonus;
        this.condition = condition;
    }

    public static Prize findPrize(int matchingCount, boolean matchesBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.condition.test(matchingCount, matchesBonus))
                .findAny()
                .get();
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getMoney() {
        return money;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}

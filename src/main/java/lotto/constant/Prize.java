package lotto.constant;

import java.util.function.BiPredicate;

public enum Prize {
    FIRST((matchedCount, hasBonus) -> matchedCount == 6, 2_000_000_000),
    SECOND((matchedCount, hasBonus) -> matchedCount == 5 && hasBonus, 30_000_000),
    THIRD((matchedCount, hasBonus) -> matchedCount == 5 && !hasBonus, 1_500_000),
    FOURTH((matchedCount, hasBonus) -> matchedCount == 4, 50_000),
    FIFTH((matchedCount, hasBonus) -> matchedCount == 3, 5_000),
    NON((matchedCount, hasBonus) -> false, 0);

    private final BiPredicate<Integer, Boolean> condition;
    private final int prizeMoney;

    Prize(BiPredicate<Integer, Boolean> condition, int prizeMoney) {
        this.condition = condition;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int matchedCount, boolean hasBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matches(matchedCount, hasBonus)) {
                return prize;
            }
        }
        return NON;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private boolean matches(int count, boolean hasBonus) {
        return condition.test(count, hasBonus);
    }
}

package lotto.constant;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    FIFTH((matchedCount, hasBonus) -> matchedCount == 3, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH((matchedCount, hasBonus) -> matchedCount == 4, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD((matchedCount, hasBonus) -> matchedCount == 5 && !hasBonus, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND((matchedCount, hasBonus) -> matchedCount == 5 && hasBonus, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST((matchedCount, hasBonus) -> matchedCount == 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    NON((matchedCount, hasBonus) -> true, 0, "");

    private final BiPredicate<Integer, Boolean> condition;
    private final int prizeMoney;
    private final String resultMessage;

    Prize(final BiPredicate<Integer, Boolean> condition, final int prizeMoney, final String resultMessage) {
        this.condition = condition;
        this.prizeMoney = prizeMoney;
        this.resultMessage = resultMessage;
    }

    public static Prize getPrize(final int matchedCount, final boolean hasBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matches(matchedCount, hasBonus))
                .findFirst()
                .orElse(NON);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    private boolean matches(final int count, final boolean hasBonus) {
        return condition.test(count, hasBonus);
    }
}

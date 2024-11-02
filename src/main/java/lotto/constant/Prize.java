package lotto.constant;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    FIFTH((matchedCount, hasBonus) -> matchedCount == 3, 5_000, PrizeMessage.FIFTH_PRIZE_MESSAGE),
    FOURTH((matchedCount, hasBonus) -> matchedCount == 4, 50_000, PrizeMessage.FOURTH_PRIZE_MESSAGE),
    THIRD(
            (matchedCount, hasBonus) -> matchedCount == 5 && !hasBonus,
            1_500_000,
            PrizeMessage.THIRD_PRIZE_MESSAGE
    ),
    SECOND(
            (matchedCount, hasBonus) -> matchedCount == 5 && hasBonus,
            30_000_000,
            PrizeMessage.SECOND_PRIZE_MESSAGE
    ),
    FIRST((matchedCount, hasBonus) -> matchedCount == 6, 2_000_000_000, PrizeMessage.FIRST_PRIZE_MESSAGE),
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

    private boolean matches(final int count, final boolean hasBonus) {
        return condition.test(count, hasBonus);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}

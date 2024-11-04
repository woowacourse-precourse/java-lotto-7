package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;
import lotto.constant.prize.Condition;
import lotto.constant.prize.PrizeMoney;
import lotto.constant.prize.ResultMessage;

public enum Prize {
    FIFTH(Condition.FIFTH_PRIZE, PrizeMoney.FIFTH_PRIZE, ResultMessage.FIFTH_PRIZE),
    FOURTH(Condition.FOURTH_PRIZE, PrizeMoney.FOURTH_PRIZE, ResultMessage.FOURTH_PRIZE),
    THIRD(Condition.THIRD_PRIZE, PrizeMoney.THIRD_PRIZE, ResultMessage.THIRD_PRIZE),
    SECOND(Condition.SECOND_PRIZE, PrizeMoney.SECOND_PRIZE, ResultMessage.SECOND_PRIZE),
    FIRST(Condition.FIRST_PRIZE, PrizeMoney.FIRST_PRIZE, ResultMessage.FIRST_PRIZE),
    NON(Condition.NON_PRIZE, PrizeMoney.NON_PRIZE, ResultMessage.NON_PRIZE);

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

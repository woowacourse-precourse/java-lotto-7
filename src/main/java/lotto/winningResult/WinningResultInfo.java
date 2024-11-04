package lotto.winningResult;

import java.util.Arrays;
import lotto.lotto.MatchingCondition;

public enum WinningResultInfo {
    FIRST_RANK(2000000000L, MatchingCondition.SIX),
    SECOND_RANK(30000000L, MatchingCondition.FIVE_AND_BONUS),
    THIRD_RANK(1500000L, MatchingCondition.FIVE),
    FOURTH_RANK(50000L, MatchingCondition.FOUR),
    FIFTH_RANK(5000L, MatchingCondition.THREE),
    FAILURE_RANK(0L, MatchingCondition.FAILURE);

    private final long winningAmount;
    private final MatchingCondition condition;

    WinningResultInfo(long winningAmount, MatchingCondition condition) {
        this.winningAmount = winningAmount;
        this.condition = condition;
    }

    public static WinningResultInfo findByMatchingCondition(MatchingCondition condition) {
        return Arrays.stream(values())
                .filter(info -> info.isSameCondition(condition))
                .findFirst()
                .orElse(null);
    }

    public boolean isSameCondition(MatchingCondition condition) {
        return this.condition == condition;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public MatchingCondition getCondition() {
        return condition;
    }
}

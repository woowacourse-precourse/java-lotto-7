package lotto.winningResult;

import java.util.Arrays;
import lotto.lotto.MatchingCondition;

public enum WinningResultInfo {
    FIRST_RANK("1등", 2_000_000_000L, MatchingCondition.SIX),
    SECOND_RANK("2등", 30_000_000L, MatchingCondition.FIVE_AND_BONUS),
    THIRD_RANK("3등", 1_500_000L, MatchingCondition.FIVE),
    FOURTH_RANK("4등", 50_000L, MatchingCondition.FOUR),
    FIFTH_RANK("5등", 5_000L, MatchingCondition.THREE),
    FAILURE_RANK("탈락", 0L, MatchingCondition.FAILURE);

    private final String description;
    private final long winningAmount;
    private final MatchingCondition condition;

    WinningResultInfo(String description, long winningAmount, MatchingCondition condition) {
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public MatchingCondition getCondition() {
        return condition;
    }
}

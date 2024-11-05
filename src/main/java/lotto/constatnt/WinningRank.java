package lotto.constatnt;

public enum WinningRank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE_WITH_BONUS(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NO_PRIZE(0, 0);

    private final int requiredMatchingCount;
    private final int prizeAmount;

    WinningRank(int requiredMatchingCount, int prizeAmount) {
        this.requiredMatchingCount = requiredMatchingCount;
        this.prizeAmount = prizeAmount;
    }

    public int getRequiredMatchingCount() {
        return requiredMatchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static WinningRank determineRank(int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == FIRST_PRIZE.requiredMatchingCount) {
            return FIRST_PRIZE;
        }
        if (matchingNumbers == SECOND_PRIZE_WITH_BONUS.requiredMatchingCount && hasBonusNumber) {
            return SECOND_PRIZE_WITH_BONUS;
        }
        if (matchingNumbers == THIRD_PRIZE.requiredMatchingCount && !hasBonusNumber) {
            return THIRD_PRIZE;
        }
        if (matchingNumbers == FOURTH_PRIZE.requiredMatchingCount) {
            return FOURTH_PRIZE;
        }
        if (matchingNumbers == FIFTH_PRIZE.requiredMatchingCount) {
            return FIFTH_PRIZE;
        }
        return NO_PRIZE;
    }
}

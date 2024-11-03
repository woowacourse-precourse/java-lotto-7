package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;

public enum WinningRule {
    FIFTH_PRIZE("3개 일치 (5,000원)", 5_000),
    FOURTH_PRIZE("4개 일치 (50,000원)", 50_000),
    THIRD_PRIZE("5개 일치 (1,500,000원)", 1_500_000),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST_PRIZE("6개 일치 (2,000,000,000원)", 2_000_000_000),
    NOT_MATCHED("0개 일치 (0원)", 0);
    private final String description;
    private final int prizeAmount;

    WinningRule(String description, int prizeAmount) {
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public static WinningRule of(int matchCount, boolean bonusMatch) {
        if (matchCount < 0) {
            throw new WinningNumberException(ErrorMessages.MATCH_COUNT_NEGATIVE);
        }
        if (matchCount == 6) {
            return FIRST_PRIZE;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND_PRIZE;
        }
        if (matchCount == 5) {
            return THIRD_PRIZE;
        }
        if (matchCount == 4) {
            return FOURTH_PRIZE;
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE;
        }
        return NOT_MATCHED;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isWinning() {
        return !NOT_MATCHED.getDescription().equals(this.description);
    }
}
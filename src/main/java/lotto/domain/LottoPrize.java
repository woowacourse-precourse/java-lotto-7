package lotto.domain;

import static lotto.constant.LotteryConstant.MATCH_FIVE_NUMBERS_AND_BONUS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_FIVE_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_FOUR_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_SIX_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_THREE_NUMBERS_WINNING_AMOUNT;

public enum LottoPrize {
    THREE_MATCH(3, false, MATCH_FIVE_NUMBERS_AND_BONUS_WINNING_AMOUNT, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, false, MATCH_FIVE_NUMBERS_WINNING_AMOUNT, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, false, MATCH_FOUR_NUMBERS_WINNING_AMOUNT, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(5, true, MATCH_SIX_NUMBERS_WINNING_AMOUNT, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, false, MATCH_THREE_NUMBERS_WINNING_AMOUNT, "6개 일치 (2,000,000,000원)");

    private final int matchingCount;
    private final boolean isBonus;
    private final int winningAmount;
    private final String description;

    LottoPrize(int matchingCount, boolean isBonus, int winningAmount, String description) {
        this.matchingCount = matchingCount;
        this.isBonus = isBonus;
        this.winningAmount = winningAmount;
        this.description = description;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getDescription() {
        return description;
    }

    public static LottoPrize valueOf(int matchingCount, boolean isBonus) {
        for (LottoPrize prize : values()) {
            if (prize.matchingCount == matchingCount && prize.isBonus == isBonus) {
                return prize;
            }
        }
        return null;
    }
}

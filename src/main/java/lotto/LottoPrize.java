package lotto;

import static lotto.AppConstants.MATCH_COUNT_FOR_FIFTH_PRIZE;
import static lotto.AppConstants.MATCH_COUNT_FOR_FIRST_PRIZE;
import static lotto.AppConstants.MATCH_COUNT_FOR_FOURTH_PRIZE;
import static lotto.AppConstants.MATCH_COUNT_FOR_SECOND_PRIZE;
import static lotto.AppConstants.MATCH_COUNT_FOR_THIRD_PRIZE;

public enum LottoPrize {
    FIFTH_PRIZE(MATCH_COUNT_FOR_FIFTH_PRIZE, 5000), FOURTH_PRIZE(MATCH_COUNT_FOR_FOURTH_PRIZE, 50000), THIRD_PRIZE(MATCH_COUNT_FOR_THIRD_PRIZE, 1500000),
    FIRST_PRIZE(MATCH_COUNT_FOR_FIRST_PRIZE, 2000000000), SECOND_PRIZE(MATCH_COUNT_FOR_SECOND_PRIZE, 30000000);

    private final int matchCount;
    private final int prize;
    private int winningCount;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public void addWinningCount() {
        this.winningCount++;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

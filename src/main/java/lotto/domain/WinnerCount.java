package lotto.domain;

import static lotto.utils.Constants.FIFTH;
import static lotto.utils.Constants.FIRST;
import static lotto.utils.Constants.FOURTH;
import static lotto.utils.Constants.SECOND;
import static lotto.utils.Constants.THIRD;

public class WinnerCount {

    private final int matchedCount;
    private final boolean hasBonus;

    public WinnerCount(int matchedCount, boolean hasBonus) {
        this.matchedCount = matchedCount;
        this.hasBonus = hasBonus;
    }

    public static WinnerCount of(int winnerCount, boolean hasBonus) {
        return new WinnerCount(winnerCount, hasBonus);
    }

    protected Integer calculateReward() {
        if (matchedCount == 6) {
            return FIRST;
        }

        if (matchedCount == 5 && hasBonus) {
            return SECOND;
        }

        int totalWins = calculateTotalWins();

        if (totalWins == 5) {
            return THIRD;
        }

        if (totalWins == 4) {
            return FOURTH;
        }

        if (totalWins == 3) {
            return FIFTH;
        }

        return 0;
    }

    private int calculateTotalWins() {
        int matchedCountWithBonus = matchedCount;

        if (hasBonus) {
            matchedCountWithBonus += 1;
        }

        return matchedCountWithBonus;
    }

}

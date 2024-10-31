package lotto.enumerate;

import java.util.HashMap;
import java.util.Map;
import lotto.view.InputView;

public enum Prize {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final Boolean bonusMatch;
    private final int prizeAmount;
    private int count;

    Prize(int matchCount, Boolean bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
        this.count = 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean getBonusMatch() {
        return bonusMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return matchCount + "개 일치"
                + "(" + prizeAmount + ")"
                + " - " + count + "개";
    }

}

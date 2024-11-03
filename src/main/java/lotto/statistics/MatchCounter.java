package lotto.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchCounter {

    private static final int COUNTER_CHANGE_POINT = 5;
    private static final int COUNTER_UP = 1;

    private final List<Integer> matchedNumbers = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));

    public void updateMatchResult(int matchedCount, boolean matchingBonusResult) {
        int index = matchedCount;

        if (matchedCount >= COUNTER_CHANGE_POINT) {
            index = checkMatchedAllOrBonus(matchedCount, matchingBonusResult);
        }
        matchedNumbers.set(index, matchedNumbers.get(index) + COUNTER_UP);
    }

    public List<Integer> getMatchedNumbers() {
        return matchedNumbers;
    }

    private int checkMatchedAllOrBonus(int matchedCount, boolean matchingBonusResult) {
        if (matchedCount == COUNTER_CHANGE_POINT && !matchingBonusResult) {
            return matchedCount;
        }
        return ++matchedCount;
    }
}

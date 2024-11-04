package lotto.model;

import lotto.constants.Constants;
import lotto.enumerate.MatchedCountKeyEnum;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<String, Integer> matchedCount;

    public LottoResult() {
        this.matchedCount = new HashMap<>();
        matchedCount.put(MatchedCountKeyEnum.THREE_MATCHED.getKey(), Constants.INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountKeyEnum.FOUR_MATCHED.getKey(), Constants.INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountKeyEnum.FIVE_MATCHED.getKey(), Constants.INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountKeyEnum.FIVE_WITH_BONUS_MATCHED.getKey(), Constants.INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountKeyEnum.SIX_MATCHED.getKey(), Constants.INITIAL_MATCHED_COUNT);
    }

    public void increaseCountByNumberMatchedAndBonusMatched(int numberMatchedCount, boolean isBonusMatched) {
        if (numberMatchedCount == 3) {
            increaseThree();
            return;
        }
        if (numberMatchedCount == 4) {
            increaseFour();
            return;
        }
        if (numberMatchedCount == 5) {
            increaseFive(isBonusMatched);
            return;
        }
        if (numberMatchedCount == 6) {
            increaseSix();
            return;
        }
    }

    private void increaseThree() {
        int currentCount = matchedCount.get(MatchedCountKeyEnum.THREE_MATCHED.getKey());
        matchedCount.put(MatchedCountKeyEnum.THREE_MATCHED.getKey(), currentCount+1);
    }

    private void increaseFour() {
        int currentCount = matchedCount.get(MatchedCountKeyEnum.FOUR_MATCHED.getKey());
        matchedCount.put(MatchedCountKeyEnum.FOUR_MATCHED.getKey(), currentCount+1);
    }

    private void increaseFive(boolean isBonusMatched) {
        if (isBonusMatched) {
            int currentCount = matchedCount.get(MatchedCountKeyEnum.FIVE_WITH_BONUS_MATCHED.getKey());
            matchedCount.put(MatchedCountKeyEnum.FIVE_WITH_BONUS_MATCHED.getKey(), currentCount+1);
            return;
        }
        int currentCount = matchedCount.get(MatchedCountKeyEnum.FIVE_MATCHED.getKey());
        matchedCount.put(MatchedCountKeyEnum.FIVE_MATCHED.getKey(), currentCount+1);
    }

    private void increaseSix() {
        int currentCount = matchedCount.get(MatchedCountKeyEnum.SIX_MATCHED.getKey());
        matchedCount.put(MatchedCountKeyEnum.SIX_MATCHED.getKey(), currentCount+1);
    }

    public Map<String, Integer> getMatchedCount() {
        return this.matchedCount;
    }
}

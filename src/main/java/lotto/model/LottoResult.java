package lotto.model;

import lotto.utility.MatchedCountNameEnum;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int INITIAL_MATCHED_COUNT = 0;
    private static final int MATCH_3 = 3;
    private static final int MATCH_4 = 4;
    private static final int MATCH_5 = 5;
    private static final int MATCH_6 = 6;
    private Map<String, Integer> matchedCount;

    public LottoResult() {
        this.matchedCount = new HashMap<>();
        matchedCount.put(MatchedCountNameEnum.THREE_MATCHED.getMessage(), INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountNameEnum.FOUR_MATCHED.getMessage(), INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountNameEnum.FIVE_MATCHED.getMessage(), INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountNameEnum.FIVE_WITH_BONUS_MATCHED.getMessage(), INITIAL_MATCHED_COUNT);
        matchedCount.put(MatchedCountNameEnum.SIX_MATCHED.getMessage(), INITIAL_MATCHED_COUNT);
    }

    public void increaseCountByNumberMatchedAndBonusMatched(int numberMatchedCount, boolean isBonusMatched) {
        if (numberMatchedCount == MATCH_3) {
            increaseThree();
            return;
        }
        if (numberMatchedCount == MATCH_4) {
            increaseFour();
            return;
        }
        if (numberMatchedCount == MATCH_5) {
            increaseFive(isBonusMatched);
            return;
        }
        if (numberMatchedCount == MATCH_6) {
            increaseSix();
            return;
        }
    }

    private void increaseThree() {
        int currentCount = matchedCount.get("threeMatched");
        matchedCount.put("threeMatched", currentCount+1);
    }

    private void increaseFour() {
        int currentCount = matchedCount.get("fourMatched");
        matchedCount.put("fourMatched", currentCount+1);
    }

    private void increaseFive(boolean isBonusMatched) {
        if (isBonusMatched) {
            int currentCount = matchedCount.get("fiveWithBonusMatched");
            matchedCount.put("fiveWithBonusMatched", currentCount+1);
            return;
        }
        int currentCount = matchedCount.get("fiveMatched");
        matchedCount.put("fiveMatched", currentCount+1);
    }

    private void increaseSix() {
        int currentCount = matchedCount.get("sixMatched");
        matchedCount.put("sixMatched", currentCount+1);
    }

    public Map<String, Integer> getMatchedCount() {
        return this.matchedCount;
    }
}

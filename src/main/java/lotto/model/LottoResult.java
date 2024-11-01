package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<String, Integer> matchedCount;

    public LottoResult() {
        this.matchedCount = new HashMap<>();
        matchedCount.put("threeMatched", 0);
        matchedCount.put("fourMatched", 0);
        matchedCount.put("fiveMatched", 0);
        matchedCount.put("fiveWithBonusMatched", 0);
        matchedCount.put("sixMatched", 0);
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

    public int getMatchThreeNumberCount() {
        return matchedCount.get("threeMatched");
    }
    public int getMatchFourNumberCount() {
        return matchedCount.get("fourMatched");
    }
    public int getMatchFiveNumberCount() {
        return matchedCount.get("fiveMatched");
    }
    public int getMatchFiveNumberAndBonusCount() {
        return matchedCount.get("fiveWithBonusMatched");
    }
    public int getMatchSixNumberCount() {
        return matchedCount.get("sixMatched");
    }
}

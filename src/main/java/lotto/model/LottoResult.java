package lotto.model;

import lotto.constant.LottoConstant;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> matchCounts;
    private Map<Integer, Integer> prizeMoney;

    public LottoResult(){
        this.matchCounts = initializeMatchCounts();
        this.prizeMoney = initializePrizeMoney();
    }

    public Map<Integer, Integer> getMatchCounts() {
        return matchCounts;
    }

    public Map<Integer, Integer> getPrizeMoney(){
        return prizeMoney;
    }

    public void addMatchCount(int matchCount) {
        int currentValue = matchCounts.getOrDefault(matchCount, 0);
        matchCounts.put(matchCount, currentValue + 1);
    }

    private Map<Integer, Integer> initializeMatchCounts(){
        Map<Integer, Integer> matchCounts = new HashMap<>();
        for(int i=0;i< LottoConstant.LOTTO_NUMBER_COUNT+1;i++){
            matchCounts.put(i,0);
        }
        matchCounts.put(LottoMatchResult.FIVE_MATCH_WITH_BONUS.getMatchCount(), 0);
        return matchCounts;
    }

    private Map<Integer, Integer> initializePrizeMoney(){
        Map<Integer, Integer> prizeMoney = new HashMap<>();
        for (LottoMatchResult stats : LottoMatchResult.values()) {
            prizeMoney.put(stats.getMatchCount(), stats.getPrize());
        }
        return prizeMoney;
    }
}

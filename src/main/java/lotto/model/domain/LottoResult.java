package lotto.model.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<String, Integer> matchStatus;
    private final Map<String, Integer> prizeAmounts;
    private int totalPrize;

    public LottoResult() {
        matchStatus = new HashMap<>();
        prizeAmounts = new HashMap<>();
        totalPrize = 0;

        initializeMatchStatus();
        initializePrizeAmounts();
    }

    private void initializeMatchStatus() {
        matchStatus.put("three_match", 0);
        matchStatus.put("four_match", 0);
        matchStatus.put("five_match", 0);
        matchStatus.put("five_bonus_match", 0);
        matchStatus.put("six_match", 0);
    }

    private void initializePrizeAmounts() {
        prizeAmounts.put("three_match", 5000);
        prizeAmounts.put("four_match", 50000);
        prizeAmounts.put("five_match", 1500000);
        prizeAmounts.put("five_bonus_match", 30000000);
        prizeAmounts.put("six_match", 2000000000);
    }

    public void updateMatchStatus(String matchCount) {
        matchStatus.put(matchCount,matchStatus.get(matchCount)+1);
        totalPrize += prizeAmounts.getOrDefault(matchCount, 0);
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public Map<String,Integer> getMatchStatus() {
        return matchStatus;
    }
}

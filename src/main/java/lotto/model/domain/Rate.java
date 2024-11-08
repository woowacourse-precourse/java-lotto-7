package lotto.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Rate {
    private final Map<String, Integer> matchStatus;
    private final Map<String, Integer> prizeAmounts;
    private int totalPrize;

    public Rate() {
        matchStatus = new HashMap<>();
        prizeAmounts = new HashMap<>();
        totalPrize = 0;

        initializeMatchStatus();
        initializePrizeAmounts();
    }

    // 초기화 메서드들
    private void initializeMatchStatus() {
        matchStatus.put("three_match", 0);
        matchStatus.put("four_match", 0);
        matchStatus.put("five_match", 0);
        matchStatus.put("five_bonus_match", 0);
        matchStatus.put("six_match", 0);
    }

    private void initializePrizeAmounts() {
        prizeAmounts.put("three_match", 5000);         // 3개 일치 상금
        prizeAmounts.put("four_match", 50000);         // 4개 일치 상금
        prizeAmounts.put("five_match", 1500000);       // 5개 일치 상금
        prizeAmounts.put("five_bonus_match", 30000000); // 5개 + 보너스 일치 상금
        prizeAmounts.put("six_match", 2000000000);     // 6개 일치 상금
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

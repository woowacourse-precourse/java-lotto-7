package lotto.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final int[] matchCounts = new int[5];

    private static final Map<String, Integer> resultIndexMap = new HashMap<>();

    static {
        resultIndexMap.put("6_0", 4);  // 6개 일치 (1등)
        resultIndexMap.put("5_1", 3);  // 5개 + 보너스 일치 (2등)
        resultIndexMap.put("5_0", 2);  // 5개 일치 (3등)
        resultIndexMap.put("4_0", 1);  // 4개 일치 (4등)
        resultIndexMap.put("3_0", 0);  // 3개 일치 (5등)
    }

    public void updateStatistics(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        int bonusMatch = lotto.containsBonusNumber(bonusNumber) ? 1 : 0;

        String key = matchCount + "_" + bonusMatch;

        if (resultIndexMap.containsKey(key)) {
            matchCounts[resultIndexMap.get(key)]++;
        }
    }

    public double calculateYield(int totalAmount) {
        int[] prizeMoney = {5000, 50000, 1500000, 30000000, 2000000000};
        int totalPrize = 0;
        for (int i = 0; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * prizeMoney[i];
        }
        return (double) totalPrize / totalAmount * 100;
    }

    public int[] getMatchCounts() {
        return matchCounts;
    }
}

package lotto.domain.winning;

import java.util.HashMap;
import java.util.Map;

public class WinningStatus {

    private final Map<String, Integer> prizeCounts = new HashMap<>();
    private final Map<String, Integer> prizeAmounts = new HashMap<>();

    public WinningStatus() {
        prizeCounts.put("3개", 0);
        prizeCounts.put("4개", 0);
        prizeCounts.put("5개", 0);
        prizeCounts.put("5개 + 보너스", 0);
        prizeCounts.put("6개", 0);

        prizeAmounts.put("3개", 5000);
        prizeAmounts.put("4개", 50000);
        prizeAmounts.put("5개", 1500000);
        prizeAmounts.put("5개 + 보너스", 30000000);
        prizeAmounts.put("6개", 2000000000);
    }

    public void addWinning(String category) {
        prizeCounts.put(category, prizeCounts.get(category) + 1);
    }

    public int getPrizeCount(String category) {
        return prizeCounts.getOrDefault(category, 0);
    }

    public int getPrizeAmount(String category) {
        return prizeAmounts.getOrDefault(category, 0);
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;
        for (String category : prizeCounts.keySet()) {
            totalPrize += prizeCounts.get(category) * prizeAmounts.get(category);
        }
        return totalPrize;
    }
}
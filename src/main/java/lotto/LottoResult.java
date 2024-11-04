package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeCounts = new HashMap<>();
    private final Map<Integer, Integer> prizeAmounts = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000,
            7, 30000000 // 2등: 5개 + 보너스 일치
    );

    public LottoResult() {
        for (int key : prizeAmounts.keySet()) {
            prizeCounts.put(key, 0);
        }
    }

    public void addResult(int matchCount) {
        if (prizeCounts.containsKey(matchCount)) {
            prizeCounts.put(matchCount, prizeCounts.get(matchCount) + 1);
        }
    }

    public void printResult() {
        System.out.println("3개 일치 (5,000원) - " + prizeCounts.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCounts.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCounts.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCounts.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCounts.get(6) + "개");
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = 0;
        for (Map.Entry<Integer, Integer> entry : prizeCounts.entrySet()) {
            totalPrize += entry.getValue() * prizeAmounts.get(entry.getKey());
        }
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}

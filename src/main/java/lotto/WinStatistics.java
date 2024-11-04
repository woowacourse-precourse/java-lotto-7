package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinStatistics {
    private final Map<Integer, Integer> winResults = new HashMap<>();
    private final Map<Integer, Integer> prizeMap = Map.of(
            6, 2000000000,
            5, 30000000,
            4, 1500000,
            3, 50000,
            2, 5000
    );

    public WinStatistics() {
        winResults.put(6, 0);
        winResults.put(5, 0);
        winResults.put(4, 0);
        winResults.put(3, 0);
        winResults.put(2, 0);
    }

    public void recordResult(int winCategory) {
        if (winResults.containsKey(winCategory)) {
            winResults.put(winCategory, winResults.get(winCategory) + 1);
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        winResults.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf("%d개 일치 (%d원) - %d개\n", key, prizeMap.get(key), value);
            }
        });
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = winResults.entrySet().stream()
                .mapToInt(entry -> prizeMap.getOrDefault(entry.getKey(), 0) * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}

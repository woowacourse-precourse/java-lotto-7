package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinStatistics {
    private final Map<Integer, Integer> winResults = new HashMap<>();
    private final Map<Integer, Integer> prizeMap = Map.of(
            1, 2000000000, // 1등
            2, 30000000,   // 2등
            3, 1500000,    // 3등
            4, 50000,      // 4등
            5, 5000        // 5등
    );

    public WinStatistics() {
        winResults.put(1, 0); // 1등
        winResults.put(2, 0); // 2등
        winResults.put(3, 0); // 3등
        winResults.put(4, 0); // 4등
        winResults.put(5, 0); // 5등
    }

    public void recordResult(int winCategory) {
        if (winResults.containsKey(winCategory)) {
            winResults.put(winCategory, winResults.get(winCategory) + 1);
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winResults.get(5));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winResults.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winResults.get(3));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winResults.get(2));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winResults.get(1));
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = winResults.entrySet().stream()
                .mapToInt(entry -> prizeMap.getOrDefault(entry.getKey(), 0) * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}

package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private Map<String, Integer> statistics;

    public LottoStatistics() {
        statistics = new HashMap<>();
        statistics.put("3개 일치 (5,000원)", 0);
        statistics.put("4개 일치 (50,000원)", 0);
        statistics.put("5개 일치 (1,500,000원)", 0);
        statistics.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        statistics.put("6개 일치 (2,000,000,000원)", 0);
    }

    public void increment(String key) {
        statistics.put(key, statistics.get(key) + 1);
    }

    public Map<String, Integer> getStatistics() {
        return statistics;
    }

    public double calculateTotalEarnings() {
        double total = 0.0;
        total += statistics.get("3개 일치 (5,000원)") * 5000;
        total += statistics.get("4개 일치 (50,000원)") * 50000;
        total += statistics.get("5개 일치 (1,500,000원)") * 1500000;
        total += statistics.get("5개 일치, 보너스 볼 일치 (30,000,000원)") * 30000000;
        total += statistics.get("6개 일치 (2,000,000,000원)") * 2000000000;
        return total;
    }

    public double calculateYield(int purchaseAmount) {
        double totalEarnings = calculateTotalEarnings();
        double yield = (totalEarnings / purchaseAmount) * 100; // 수익률 계산
        return Math.round(yield * 100.0) / 100.0; // 소수점 둘째 자리에서 반올림
    }

    public void printStatistics(int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        statistics.forEach((key, value) -> {
            System.out.printf("%s - %d개%n", key, value);
        });
        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculateYield(amount));
    }
}
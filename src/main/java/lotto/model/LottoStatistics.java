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

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        statistics.forEach((key, value) -> {
            System.out.printf("%s - %d개%n", key, value);
        });
    }
}
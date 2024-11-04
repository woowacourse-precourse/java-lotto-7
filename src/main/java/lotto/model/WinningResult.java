package lotto.model;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);
    private final int purchaseAmount;

    public WinningResult(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public Map<Rank, Integer> getResultMap() {
        return results;
    }

    // 수익률 계산
    private double calculateProfitRate(int purchaseAmount) {
        int totalReward = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        return ((double) totalReward / purchaseAmount) * 100;
    }

    public void printWinningResult(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개%n", results.getOrDefault(Rank.THREE, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.getOrDefault(Rank.FOUR, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.getOrDefault(Rank.FIVE, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.getOrDefault(Rank.FIVE_BONUS, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.getOrDefault(Rank.SIX, 0));

        double profitRate = calculateProfitRate(purchaseAmount);
        DecimalFormat df = new DecimalFormat("#,##0.0");  // 쉼표와 소수점 둘째 자리까지 형식 지정
        System.out.printf("총 수익률은 %s%%입니다.%n", df.format(profitRate));
    }
}

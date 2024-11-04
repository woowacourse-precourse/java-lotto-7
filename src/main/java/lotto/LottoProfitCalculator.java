package lotto;

import java.util.Map;

public class LottoProfitCalculator {

    public static void calculateAndPrintProfit(int purchaseAmount, Map<Integer, Integer> resultCounts, int firstPrizeCount, int secondPrizeCount) {
        int totalPrize = 0;

        // 각 당첨 등수의 상금 누적 계산
        totalPrize += firstPrizeCount * 2_000_000_000;
        totalPrize += secondPrizeCount * 30_000_000;
        totalPrize += resultCounts.getOrDefault(5, 0) * 1_500_000;
        totalPrize += resultCounts.getOrDefault(4, 0) * 50_000;
        totalPrize += resultCounts.getOrDefault(3, 0) * 5_000;

        // 수익률 계산 및 반올림
        double profitRate = (totalPrize / (double) purchaseAmount) * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;  // 소수점 둘째 자리에서 반올림

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}

package lotto.view;

import java.util.Map;

public class LottoResultPrinter {
    private static final int LOTTO_PRICE = 1000;

    public void printResult(Map<Integer, Integer> resultCount, int totalPrize, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", resultCount.getOrDefault(3, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", resultCount.getOrDefault(4, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", resultCount.getOrDefault(5, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", resultCount.getOrDefault(5, 0)); // 2등
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", resultCount.getOrDefault(6, 0));

        double profitRate = calculateProfitRate(totalPrize, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private double calculateProfitRate(int totalPrize, int purchaseAmount) {
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 100) / 10.0; // 소수점 둘째 자리에서 반올림
    }
}

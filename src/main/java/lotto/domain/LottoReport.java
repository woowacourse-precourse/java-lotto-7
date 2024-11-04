package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoReport {
    private final Map<Integer, Integer> report = new LinkedHashMap<>() {{
        put(3, 0);
        put(4, 0);
        put(5, 0);
        put(55, 0);
        put(6, 0);
    }};

    private final int purchaseAmount;

    public LottoReport(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void updateReport(int numberMatch, int bonusMatch) {
        if (numberMatch < 3) {
            return;
        }

        if (numberMatch == 5 && bonusMatch == 1) {
            numberMatch = 55;
        }
        report.compute(numberMatch, (k, v) -> v + 1);
    }

    public void printReport() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Map.Entry<Integer, Integer> entry : report.entrySet()) {
            int balls = entry.getKey();
            int matches = entry.getValue();
            if (balls == 55) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", LottoPrize.getPrize(balls), matches);
            } else {
                System.out.printf("%d개 일치 (%,d원) - %d개\n", balls, LottoPrize.getPrize(balls), matches);
            }
        }
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", calculateReturnRate());
    }

    public long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Integer, Integer> entry : report.entrySet()) {
            int matchCount = entry.getKey();
            int matchTimes = entry.getValue();
            totalPrize += LottoPrize.getPrize(matchCount) * matchTimes;
        }
        return totalPrize;
    }

    public double calculateReturnRate() {
        long totalPrize = calculateTotalPrize();
        return (totalPrize / (double) purchaseAmount) * 100;
    }
}

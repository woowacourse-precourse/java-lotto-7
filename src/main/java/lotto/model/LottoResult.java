package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> prizeSheet;
    private final Map<Integer, Integer> result;
    private final int bonusMatchPrize;
    private Integer revenue = 0;

    public LottoResult() {
        prizeSheet = new HashMap<>();
        prizeSheet.put(3, 5000);              // 3개 일치
        prizeSheet.put(4, 50000);             // 4개 일치
        prizeSheet.put(5, 1500000);           // 5개 일치
        bonusMatchPrize = 30000000;           // 5개 + 보너스 일치
        prizeSheet.put(6, 2000000000);        // 6개 일치

        result = new HashMap<>();
        for (int i = 3; i <= 6; i++) {
            result.put(i, 0);
        }
        result.put(15, 0);                    // 보너스 포함 5개 일치
    }

    public void recordResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            result.put(15, result.get(15) + 1);
            addRevenue(bonusMatchPrize);
            return;
        }

        if (matchCount >= 3) {
            result.put(matchCount, result.get(matchCount) + 1);
            addRevenue(prizeSheet.get(matchCount));
        }
    }

    public void printResults() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(15) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(6) + "개");
    }

    public void addRevenue(Integer addRevenue) {
        revenue += addRevenue;
    }

    public void finalizeLottoResultsProcess(int lottoAmount) {
        printResults();
        double profitRate = computeProfitRate(lottoAmount);
        printProfitRate(profitRate);
    }

    public double computeProfitRate(int lottoAmount) {
        if (revenue == 0) {
            return 0;
        }
        return (double) revenue / (lottoAmount * 1000) * 100;
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}

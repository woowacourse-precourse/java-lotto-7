package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeCount = new HashMap<>();
    private int totalPrize = 0;

    private static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private static final int SECOND_PRIZE_BONUS = 30000000;

    public LottoResult() {
        for (int i = 3; i <= 6; i++) {
            prizeCount.put(i, 0);
        }
        prizeCount.put(-1, 0); // 2등(보너스 포함) 카운트
    }

    public void addResult(int matchingCount, boolean bonusMatch) {
        if (matchingCount == 6) {
            prizeCount.put(6, prizeCount.get(6) + 1);
            totalPrize += PRIZE_MONEY.get(6);
            return;
        }
        if (matchingCount == 5 && bonusMatch) {
            prizeCount.put(-1, prizeCount.get(-1) + 1); // 2등
            totalPrize += SECOND_PRIZE_BONUS;
            return;
        }
        if (matchingCount == 5) {
            prizeCount.put(5, prizeCount.get(5) + 1);
            totalPrize += PRIZE_MONEY.get(5);
            return;
        }
        if (matchingCount == 4) {
            prizeCount.put(4, prizeCount.get(4) + 1);
            totalPrize += PRIZE_MONEY.get(4);
            return;
        }
        if (matchingCount == 3) {
            prizeCount.put(3, prizeCount.get(3) + 1);
            totalPrize += PRIZE_MONEY.get(3);
        }
    }


    public void printStatistics(int purchaseAmount) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + prizeCount.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount.get(-1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount.get(6) + "개");

        double profitRate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}

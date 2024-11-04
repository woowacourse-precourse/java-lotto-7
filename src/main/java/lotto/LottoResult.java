package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> prizeCount = new HashMap<>();
    private int totalPrize = 0;

    public LottoResult() {
        for (int i = 3; i <= 6; i++) {
            prizeCount.put(i, 0);
        }
        prizeCount.put(-1, 0); // For bonus match count
    }

    public void addResult(int matchingCount, boolean bonusMatch) {
        if (matchingCount < 3 || matchingCount > 6) return;

        int prizeKey = (matchingCount == 5 && bonusMatch) ? -1 : matchingCount;
        prizeCount.put(prizeKey, prizeCount.get(prizeKey) + 1);

        totalPrize += (prizeKey == -1)
                ? Prize.SECOND_PRIZE_BONUS.getPrizeMoney()
                : Prize.getPrizeMoneyByCount(prizeKey);
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

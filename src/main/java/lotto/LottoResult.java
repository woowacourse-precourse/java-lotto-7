package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> results = new HashMap<>();

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
    }

    public void updateResult(int matchCount, boolean bonusMatch) {
        LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
        results.put(rank, results.get(rank) + 1);
    }

    public void printResult(int purchaseAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = results.get(rank);
                System.out.println(rank + " - " + count + "개");
                totalPrize += rank.getPrize() * count;
            }
        }
        double profitRate = (totalPrize / (double) purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}

package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultMap = new HashMap<>();
    private final int totalPrize;

    public LottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }
        int totalPrize = 0;
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.containsNumber(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.get(rank) + 1);
            totalPrize += rank.getPrize();
        }
        this.totalPrize = totalPrize;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                        rank.getMatchCount(),
                        rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "",
                        rank.getPrize(),
                        resultMap.get(rank));
            }
        }
    }

    public double calculateYield(int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}

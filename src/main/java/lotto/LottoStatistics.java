package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoRank, Integer> statistics = new HashMap<>();
    private int totalPrize = 0;

    public LottoStatistics(List<List<Integer>> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        calculateStatistics(userLottos, winningNumbers, bonusNumber);
    }

    private void calculateStatistics(List<List<Integer>> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (List<Integer> lotto : userLottos) {
            int matchCount = (int) lotto.stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.contains(bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            if (rank != LottoRank.NONE) {
                statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
                totalPrize += rank.getPrize();
            }
        }
    }

    public void printStatistics(int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue; // NONE은 출력하지 않음
            int count = statistics.getOrDefault(rank, 0);
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getPrize(), count);
        }
        double yield = ((double) totalPrize / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}

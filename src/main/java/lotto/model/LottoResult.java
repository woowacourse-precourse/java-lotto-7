package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();
    private final int totalWinnings;

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        totalWinnings = calculateTotalWinnings(lottos, winningNumbers, bonusNumber);
    }

    private int calculateTotalWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int winnings = 0;
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(lotto, winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
            winnings += rank.getPrize();
        }
        return winnings;
    }

    public double calculateYield(int purchaseAmount) {
        return (double) totalWinnings / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }
}

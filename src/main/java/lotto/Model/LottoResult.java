package lotto.Model;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final Map<Rank, Integer> winningCounts = new HashMap<>();

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(lotto, winningLotto);
            winningCounts.put(rank, winningCounts.getOrDefault(rank, 0) + 1);
        }
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalProfit = winningCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalProfit / purchaseAmount * 100;
    }

    public Map<Rank, Integer> getWinningCounts() {
        return winningCounts;
    }
}

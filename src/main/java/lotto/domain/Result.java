package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Rank;

public class Result {
    private final Map<Rank, Integer> results = new HashMap<>();

    public Result() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void calculateResults(WinningLotto winningLotto, List<Lotto> lottos) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber().getNumber();

        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            boolean isBonusMatched = isBonusMatch(lotto.getNumbers(), bonusNumber);
            Rank rank = Rank.findRank(matchCount, isBonusMatched);

            results.put(rank, results.get(rank) + 1);
        }
    }

    private int countMatches(List<Integer> playerNumbers, List<Integer> winningNumbers) {
        return (int) playerNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean isBonusMatch(List<Integer> playerNumbers, int bonusNumber) {
        return playerNumbers.contains(bonusNumber);
    }

    public int getRankCount(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount.getAmount() * 100;
    }
}

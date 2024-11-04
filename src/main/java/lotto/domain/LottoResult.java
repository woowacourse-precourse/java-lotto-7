package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Rank;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void updateRankCounts(WinningLotto winningLotto, List<Lotto> lottos) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber().getNumber();

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean isBonusNumberMatched = isBonusNumberMatched(lotto.getNumbers(), bonusNumber);
            Rank rank = Rank.findRank(matchCount, isBonusNumberMatched);

            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    private int countMatchingNumbers(List<Integer> playerNumbers, List<Integer> winningNumbers) {
        return (int) playerNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean isBonusNumberMatched(List<Integer> playerNumbers, int bonusNumber) {
        return playerNumbers.contains(bonusNumber);
    }

    public int getRankCount(Rank rank) {
        return rankCounts.get(rank);
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        int totalPrize = sumTotalPrizes();
        return (double) totalPrize / purchaseAmount.getAmount() * 100;
    }

    private int sumTotalPrizes() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}

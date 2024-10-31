package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningHistory {
    private final Map<Rank, Integer> winningHistory;

    public WinningHistory(List<Integer> winningNumbersToCompare, List<Lotto> publishedLotteries, int bonusNumber) {
        winningHistory = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            winningHistory.put(rank, 0);
        }

        countWinningsOfEachRank(winningNumbersToCompare, publishedLotteries, bonusNumber);
    }

    public Map<Rank, Integer> getWinningCountOfEachRank() {
        return winningHistory;
    }

    private void countWinningsOfEachRank(List<Integer> winningNumbers,
                                         List<Lotto> publishedLotteries, int bonusNumber) {
        for (Lotto lotto : publishedLotteries) {
            int matchCount = countMatchingNumbers(winningNumbers, lotto.get());
            boolean matchBonus = lotto.get().contains(bonusNumber);

            Rank rank = Rank.assignRank(matchCount, matchBonus);

            if (rank != null) {
                winningHistory.put(rank, winningHistory.get(rank) + 1);
            }
        }
    }

    private int countMatchingNumbers(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int count = 0;

        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }
}

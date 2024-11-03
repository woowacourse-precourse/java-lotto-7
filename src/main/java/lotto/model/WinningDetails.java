package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningDetails {
    private final Map<Rank, Integer> winningCountOfEachRanks;
    private int totalPrize;

    public WinningDetails(List<Integer> winningNumbers, List<Lotto> publishedLotteries, int bonusNumber) {
        winningCountOfEachRanks = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            winningCountOfEachRanks.put(rank, 0);
        }

        countWinningsOfEachRank(winningNumbers, publishedLotteries, bonusNumber);
    }

    public Map<Rank, Integer> getWinningCountOfEachRank() {
        return winningCountOfEachRanks;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    private void countWinningsOfEachRank(List<Integer> winningNumbers,
                                         List<Lotto> publishedLotteries, int bonusNumber) {
        for (Lotto lotto : publishedLotteries) {
            int matchCount = getMatchingNumberCount(winningNumbers, lotto.get());
            boolean matchBonus = lotto.get().contains(bonusNumber);

            Rank rank = Rank.assignRank(matchCount, matchBonus);

            if (rank != null) {
                winningCountOfEachRanks.put(rank, winningCountOfEachRanks.get(rank) + 1);
                sumTotalPrize(rank.getPrize());
            }
        }
    }

    private int getMatchingNumberCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int count = 0;

        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private void sumTotalPrize(int prize) {
        totalPrize += prize;
    }
}

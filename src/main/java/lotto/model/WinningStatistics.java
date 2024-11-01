package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = new HashMap<>();
        initializeWinningStatistics();
    }

    private void initializeWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, 0);
        }
    }

    public void createStatistics(List<Lotto> lottoTicket, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoTicket) {
            process(lotto, winningNumbers);
        }
    }

    public void process(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers.getWinningNumbers());
        boolean isBonusMatch = checkBonusMatch(lotto, winningNumbers);
        updateWinningStatistics(matchCount, isBonusMatch);
    }

    public int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean checkBonusMatch(Lotto lotto, WinningNumbers winningNumbers) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    public void updateWinningStatistics(int matchCount, boolean isBonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.checkRank(matchCount, isBonusMatch)) {
                winningStatistics.put(rank, winningStatistics.get(rank) + 1);
                return;
            }
        }
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entryRank : winningStatistics.entrySet()) {
            Rank rank = entryRank.getKey();
            int count = entryRank.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    public double getRateOfReturn(Money money) {
        return ((double) getTotalPrize() / money.getMoney()) * 100;
    }
}

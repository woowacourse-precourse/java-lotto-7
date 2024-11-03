package lotto.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int INITIAL_WINNING_COUNT = 0;
    private static final int INCREMENT_COUNT = 1;
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics() {
        this.winningStatistics = new LinkedHashMap<>();
        initializeWinningStatistics();
    }

    private void initializeWinningStatistics() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, INITIAL_WINNING_COUNT);
        }
    }

    public void createStatistics(List<Lotto> lottoTicket, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoTicket) {
            process(lotto, winningNumbers);
        }
    }

    public void process(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers.getWinningNumbers());
        boolean isBonusMatch = checkBonusMatch(lotto.getNumbers(), winningNumbers.getBonusNumber());
        updateWinningStatistics(matchCount, isBonusMatch);
    }

    public int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean checkBonusMatch(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public void updateWinningStatistics(int matchCount, boolean isBonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.checkRank(matchCount, isBonusMatch)) {
                winningStatistics.put(rank, winningStatistics.get(rank) + INCREMENT_COUNT);
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
        return ((double) getTotalPrize() / money.getMoney()) * PERCENTAGE_MULTIPLIER;
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}

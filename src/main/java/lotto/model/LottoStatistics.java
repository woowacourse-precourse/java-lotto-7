package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;

public class LottoStatistics {
    private final Map<Rank, Integer> rankCounts;
    private final int totalPrize;
    private final int totalPurchaseAmount;

    public LottoStatistics(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber,
                           int totalPurchaseAmount) {
        this.rankCounts = calculateRankCounts(lottos, winningNumbers, bonusNumber);
        this.totalPrize = calculateTotalPrize();
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    private Map<Rank, Integer> calculateRankCounts(Lottos lottos, WinningNumbers winningNumbers,
                                                   BonusNumber bonusNumber) {
        Map<Rank, Integer> counts = initializeRankCounts();
        updateRankCounts(counts, lottos, winningNumbers, bonusNumber);
        return counts;
    }

    private Map<Rank, Integer> initializeRankCounts() {
        Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                counts.put(rank, 0);
            }
        }
        return counts;
    }

    private void updateRankCounts(Map<Rank, Integer> counts, Lottos lottos, WinningNumbers winningNumbers,
                                  BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            if (rank != Rank.NONE) {
                counts.put(rank, counts.get(rank) + 1);
            }
        }
    }

    private Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = countMatches(lotto.getNumbers(), winningNumbers.getWinningNumbers());
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber.getBonusNumber());
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        Set<Integer> userNumberSet = new HashSet<>(userNumbers);
        userNumberSet.retainAll(winningNumbers);
        return userNumberSet.size();
    }


    private int calculateTotalPrize() {
        int total = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            total += entry.getKey().getPrize() * entry.getValue();
        }
        return total;
    }

    public double calculateProfitRate() {
        if (totalPurchaseAmount == 0) {
            return 0;
        }
        return (double) totalPrize / totalPurchaseAmount * 100;
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }
}

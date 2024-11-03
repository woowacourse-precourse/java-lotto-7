package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Win {
    private final List<Lotto> purchasedLottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Rank, Integer> statistics;

    public Win(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.statistics = new HashMap<>();
        calculateRank();
    }

    private void calculateRank() {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = calculateMatchCount(lotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public double calculateRate(int purchaseAmount) {
        int totalPrize = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}

package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    private final RankCalculator rankCalculator;

    public LottoResultCalculator(RankCalculator rankCalculator) {
        this.rankCalculator = rankCalculator;
    }

    public Map<Rank, Integer> calculateStatistics(List<Lotto> userLottos, List<Integer> winningNumbers,
                                                  int bonusNumber) {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
        for (Lotto lotto : userLottos) {
            int matchCount = calculateMatchCount(lotto, winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            Rank rank = rankCalculator.calculateRank(matchCount, hasBonus);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

    public double calculateROI(Map<Rank, Integer> statistics, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(statistics);
        if (purchaseAmount == 0) {
            return 0;
        }
        return Math.round(((double) totalPrize / purchaseAmount * 100) * 10) / 10.0; // 소수점 둘째 자리 반올림
    }

    protected int calculateTotalPrize(Map<Rank, Integer> statistics) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}

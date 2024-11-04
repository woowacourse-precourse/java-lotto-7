package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final double TOTAL_LOTTO_PRICE = 1000.0;
    private static final int PERCENT = 100;
    private final Map<LottoRank, Integer> rankCountMap = new HashMap<>();
    private final int totalLottos;

    public WinningStatistics(int totalLottos) {
        this.totalLottos = totalLottos;
        initializeRankCount();
    }

    private void initializeRankCount() {
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    public void recordWinningStatistics(List<Integer> userNumbers, WinningLotto winningLotto) {
        int matchCount = countMatchingNumbers(userNumbers, winningLotto.getWinningNumbers());
        boolean hasBonus = winningLotto.hasBonusNumber(userNumbers);

        LottoRank rank = LottoRank.of(matchCount, hasBonus);
        rankCountMap.put(rank, rankCountMap.get(rank) + 1);

    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCountMap;
    }

    public double calculateTotalPrize() {
        return rankCountMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateReturnOnInvestment() {
        double totalPrize = calculateTotalPrize();
        double totalSpent = totalLottos * TOTAL_LOTTO_PRICE;
        return (totalPrize / totalSpent) * PERCENT;
    }
}
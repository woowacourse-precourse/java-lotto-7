package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankCount;
    private final double yield;

    public LottoResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        this.rankCount = calculateStatistics(lottos, winningLotto.getNumbers(), bonusNumber);
        this.yield = calculateYield(lottos.size());
    }

    private Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    private Rank calculateRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, hasBonus);
    }

    private double calculateYield(int totalLottos) {
        int totalWinningAmount = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();

        int totalPurchaseAmount = totalLottos * LottoConstants.LOTTO_PRICE.getValue();

        return (double) totalWinningAmount / totalPurchaseAmount * 100;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getYield() {
        return yield;
    }
}

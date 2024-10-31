package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        calculateResults(lottos, winningNumbers, bonusNumber);
    }

    private void calculateResults(List<Lotto> lottos, WinningNumbers winningNumbers,
                                  BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    private Rank calculateRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbersList = winningNumbers.getNumbers();

        long matchCount = lottoNumbers.stream()
                .filter(winningNumbersList::contains)
                .count();

        boolean matchBonus = lottoNumbers.contains(bonusNumber.getNumber());

        return Rank.valueOf((int) matchCount, matchBonus);
    }

    public int getCountByRank(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public double calculateProfit(Money money) {
        long totalPrize = rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        return (totalPrize * 100.0) / money.getAmount();
    }
}

package lotto.service;

import static lotto.constant.Constants.DEFAULT_STATISTIC_COUNT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class HitNumberCalculator {

    public Map<Rank, Integer> calculateResults(List<Lotto> purchasedLotto, List<Integer> winningNumbers,
                                               int bonusNumber) {
        Map<Rank, Integer> results = new HashMap<>();
        purchasedLotto.forEach(lotto -> updateResults(results, lotto, winningNumbers, bonusNumber));

        return results;
    }

    private void updateResults(Map<Rank, Integer> results,  Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
        results.putIfAbsent(rank, DEFAULT_STATISTIC_COUNT);
        results.put(rank, results.get(rank) + 1);
    }

    private Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = calculateMatchCount(lotto, winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, hasBonus);
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double calculateProfitRate(Map<Rank, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return (double) totalPrize / purchaseAmount * 100;
    }
}
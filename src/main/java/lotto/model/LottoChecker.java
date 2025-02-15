package lotto.model;

import lotto.model.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public Map<Rank, Integer> checkWinningStatus(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public double calculateTotalYield(Map<Rank, Integer> results, int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / purchaseAmount) * 100;
    }
}
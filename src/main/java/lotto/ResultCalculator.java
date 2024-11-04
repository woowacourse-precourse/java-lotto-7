package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {
    public Map<Rank, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private Rank getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.of((int) matchCount, bonusMatch);
    }

    public double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}

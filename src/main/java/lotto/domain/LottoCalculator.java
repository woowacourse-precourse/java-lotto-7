package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {
    private final Map<PrizeTier, Integer> results = new EnumMap<>(PrizeTier.class);

    public LottoCalculator() {
        for (PrizeTier tier : PrizeTier.values()) {
            results.put(tier, 0);
        }
    }

    public void calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto ticket : tickets) {
            int matchCnt = ticket.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = ticket.contains(bonusNumber);

            for (PrizeTier tier : PrizeTier.values()) {
                if (tier.getMatchCount() == matchCnt && tier.isBonusMatch() == bonusMatch) {
                    results.put(tier, results.get(tier) + 1);
                    break;
                }
            }
        }
    }

    public double profitRate(int purchaseAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    public Map<PrizeTier, Integer> results() {
        return results;
    }

}

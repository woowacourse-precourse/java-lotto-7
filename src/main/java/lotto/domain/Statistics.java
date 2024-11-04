package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);
    private final Purchase purchase;

    public Statistics(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber, Purchase purchase) {
        this.purchase = purchase;
        calculate(lottos, winningNumbers, bonusNumber);
    }

    private void calculate(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningNumbers, bonusNumber);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double calculateYield() {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double yield = (double) totalPrize / purchase.getAmount() * 100;
        return Math.round(yield * 10) / 10.0;
    }
}



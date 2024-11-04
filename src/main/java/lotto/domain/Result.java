package lotto.domain;

import lotto.Lotto;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Prize, Integer> results;
    private final int totalPurchaseAmount;

    public Result(List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        this.results = new EnumMap<>(Prize.class);
        this.totalPurchaseAmount = purchasedLottos.size() * 1000;
        calculateResults(purchasedLottos, winningNumber);
    }

    private void calculateResults(List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        initializeResults();
        for (Lotto lotto : purchasedLottos) {
            Prize prize = getPrize(lotto, winningNumber);
            results.put(prize, results.get(prize) + 1);
        }
    }

    private void initializeResults() {
        for (Prize prize : Prize.values()) {
            results.put(prize, 0);
        }
    }

    private Prize getPrize(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = winningNumber.matchCount(lotto);
        boolean hasBonusNumber = matchCount == 5 && winningNumber.hasBonusNumber(lotto);
        return Prize.of(matchCount, hasBonusNumber);
    }

    public Map<Prize, Integer> getResults() {
        return new EnumMap<>(results);
    }

    public double calculateReturnRate() {
        long totalPrizeAmount = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        return Math.round((double) totalPrizeAmount / totalPurchaseAmount * 1000.0) / 10.0;
    }
}
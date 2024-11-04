package lotto.domain;

import java.util.List;

public class WinningResult {

    private final List<Prize> prizes;
    private final int purchaseAmount;

    private WinningResult(final List<Prize> prizes, final int purchaseAmount) {
        this.prizes = prizes;
        this.purchaseAmount = purchaseAmount;
    }

    public static WinningResult of(final List<Lotto> lottos, final WinningNumbers winningNumbers,
                                   final int purchaseAmount) {
        List<Prize> prizes = lottos.stream()
                .map(lotto -> matchPrize(lotto, winningNumbers))
                .toList();
        return new WinningResult(prizes, purchaseAmount);
    }

    private static Prize matchPrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = lotto.countMatches(winningNumbers.lotto());
        boolean bonusMatch = lotto.contains(winningNumbers.bonusNumber());
        return Prize.of(matchCount, bonusMatch);
    }

    public int countPrize(final Prize prize) {
        return (int) prizes.stream()
                .filter(p -> p == prize)
                .count();
    }

    public double getProfitRate() {
        int totalPrizeAmount = prizes.stream()
                .mapToInt(Prize::getAmount)
                .sum();
        return Math.round(((totalPrizeAmount * 100.0) / purchaseAmount) * 10) / 10.0;
    }
}

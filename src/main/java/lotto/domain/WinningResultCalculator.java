package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningResultCalculator {

    private final List<LottoResult> results;

    private WinningResultCalculator(List<LottoResult> results) {
        this.results = results;
    }

    public static WinningResultCalculator of(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoResult> results = lottos.stream()
                .map(lotto -> LottoResult.of(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.toList());
        return new WinningResultCalculator(results);
    }

    public List<LottoResult> getResults() {
        return results;
    }

    public int calculateTotalWinnings() {
        return results.stream()
                .mapToInt(LottoResult::getWinnings)
                .sum();
    }

    public double calculateProfitRate(int purchaseAmount) {
        int totalWinnings = calculateTotalWinnings();
        return ProfitCalculator.calculateProfitRate(totalWinnings, purchaseAmount);
    }

}
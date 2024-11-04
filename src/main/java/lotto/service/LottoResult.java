package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;

public class LottoResult {
    private final Map<Ranking, Long> results;
    private final double returnRate;
    private final int purchasedCount;

    public LottoResult(List<Lotto> purchasedLotto, WinningNumbers winningNumbers, Calculator rankingCalculator) {
        this.purchasedCount = purchasedLotto.size();
        this.results = rankingCalculator.lottoResults(purchasedLotto);
        this.returnRate = rankingCalculator.calculateReturnRate(results, purchasedCount);
    }

    public Map<Ranking, Long> getResults() {
        return this.results;
    }

    public int getPurchasedCount() {
        return this.purchasedCount;
    }

    public double getReturnRate() {
        return this.returnRate;
    }

    public String formatResults() {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != Ranking.NONE) // NONE인 경우 제외
                .map(entry -> entry.getKey().getPrintMessage() + " - " + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));
    }
}

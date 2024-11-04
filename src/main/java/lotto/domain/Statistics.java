package lotto.domain;

import java.util.Map;
import java.util.List;

public class Statistics {
    private final Map<Rank, Integer> results;
    private final int purchaseAmount;

    public Statistics(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber, Purchase purchase) {
        this.purchaseAmount = purchase.getAmount();
        LottoResultCounter counter = new LottoResultCounter();
        this.results = counter.countResults(lottos, winningNumbers, bonusNumber);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double calculateYield() {
        YieldCalculator calculator = new YieldCalculator();
        return calculator.calculateYield(results, purchaseAmount);
    }
}

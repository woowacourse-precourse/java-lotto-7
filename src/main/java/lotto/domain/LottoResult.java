package lotto.domain;

import lotto.service.LottoResultCalculator;
import lotto.service.WinningResult;
import lotto.util.PrizeCalculator;

import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<WinningResult, Integer> results;
    private final int totalAmount;

    public LottoResult(final LottoResultCalculator resultCalculator, final List<Lotto> purchasedLotto, final WinningLotto winningLotto) {
        results = resultCalculator.checkLottoResult(purchasedLotto, winningLotto);
        totalAmount = PrizeCalculator.calcTotalPrizeAmount(results);
    }

    public double calculateRate(final int purchasePrice) {
        return ((double) totalAmount / purchasePrice) * 100;
    }


    public Map<WinningResult, Integer> getResults() {
        return results;
    }

}

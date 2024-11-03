package lotto.domain;

import lotto.service.WinningResult;

import java.util.Map;

public class LottoResult {
    private final Map<WinningResult, Integer> results;
    private final int totalAmount;

    public LottoResult(final Map<WinningResult, Integer> results, final int totalAmount) {
        this.results = results;
        this.totalAmount = totalAmount;
    }

    public double calculateRate(final int purchasePrice) {
        return ((double) totalAmount / purchasePrice) * 100;
    }


    public Map<WinningResult, Integer> getResults() {
        return results;
    }

}

package lotto.model;

import java.util.Comparator;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result;

    private LottoResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static LottoResult of(Map<Rank, Integer> lottoResult) {
        return new LottoResult(lottoResult);
    }

    public String getResultForDisplay() {
        StringBuilder resultForDisplay = new StringBuilder();
        getResultForDisplay(resultForDisplay);
        return resultForDisplay.toString();
    }

    public double getRateOfReturn(Money money) {
        int totalWinningAmount = getTotalWinningAmount();
        return money.getRateOfReturn(totalWinningAmount);
    }

    @Override
    public String toString() {
        return "LottoResult{" + "result=" + result + "}";
    }

    private void getResultForDisplay(StringBuilder resultForDisplay) {
        result.keySet().stream()
                .sorted(Comparator.comparingInt(Rank::getRank).reversed())
                .forEach(rank -> resultForDisplay.append(rank.getResultForDisplay(result.get(rank))));
    }

    private int getTotalWinningAmount() {
        return result.keySet().stream()
                .mapToInt(key -> result.get(key) * key.getWinnerAmount())
                .sum();
    }

}

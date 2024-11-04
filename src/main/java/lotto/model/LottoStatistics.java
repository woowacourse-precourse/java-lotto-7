package lotto.model;

import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoRank, Integer> result;
    private final double profitRate;

    public LottoStatistics(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult(lottos, winningNumbers);
        result = lottoResult.getResults();
        profitRate = calculateProfitRate(lottos.size() * 1000);
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(int totalCost) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / totalCost * 100;
    }
}
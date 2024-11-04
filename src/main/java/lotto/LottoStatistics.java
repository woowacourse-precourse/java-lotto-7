package lotto;

import java.util.Map;

public class LottoStatistics {
    public double calculateYield(int money, Map<LottoPrize, Integer> winningResult) {
        long totalPrize = winningResult.keySet().stream()
                .map(lottoPrize -> lottoPrize.getPrize() * winningResult.get(lottoPrize))
                .reduce(0L, Long::sum);
        return ((double) totalPrize / money) * 100;
    }
}

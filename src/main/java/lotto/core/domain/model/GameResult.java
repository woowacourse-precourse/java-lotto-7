package lotto.core.domain.model;

import java.util.EnumMap;
import java.util.List;


public class GameResult {
    private EnumMap<PrizeOption, Integer> resultCounts;
    private double totalProfit = 0.0;

    public GameResult(final List<PrizeOption> givenLottosResults){
        this.resultCounts = new EnumMap<>(PrizeOption.class);
        givenLottosResults.stream()
                .filter(result -> !result.equals(PrizeOption.UNDER_THREE))
                .forEach(result -> this.resultCounts.put(result, this.resultCounts.getOrDefault(result, 0) + 1));
    }
    public void countProfitable(Money money) {
        int totalPrize = resultCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        this.totalProfit = money.countPrize(totalPrize);
    }
    public EnumMap<PrizeOption, Integer> getResultCounts() {
        return resultCounts;
    }
    public double getTotalProfit() {
        return totalProfit;
    }
}

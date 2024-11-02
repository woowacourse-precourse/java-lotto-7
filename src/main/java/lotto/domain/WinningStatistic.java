package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {

    private static final int INIT_FREQUENCY = 0;
    private final Map<WinningState, Integer> stateFrequencyAccumulator = new EnumMap<>(WinningState.class);
    private final double profitRate;

    private WinningStatistic(List<LottoResult> lottoResults, Price price) {
        initialize();
        generateStatistic(lottoResults);
        this.profitRate = calculateProfitRate(price);
    }

    public static WinningStatistic from(List<LottoResult> results, Price price) {
        return new WinningStatistic(results, price);
    }

    private void initialize() {
        WinningState.stream()
                .filter(WinningState::isWinner)
                .forEach(state -> stateFrequencyAccumulator.put(state, INIT_FREQUENCY));
    }

    private void generateStatistic(List<LottoResult> lottoResults) {
        lottoResults.stream()
                .filter(LottoResult::isWinner)
                .map(LottoResult::getWinningState)
                .forEach(this::accumulateWinningState);
    }

    private double calculateProfitRate(Price price) {
        int totalPrize = calculateTotalPrize();
        int purchasePrice = price.getPrice();

        return BigDecimal.valueOf((double) totalPrize)
                .divide(BigDecimal.valueOf(purchasePrice), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private int calculateTotalPrize() {
        return stateFrequencyAccumulator.keySet().stream()
                .mapToInt(this::calculatePrize)
                .sum();
    }

    private int calculatePrize(WinningState state) {
        Integer frequency = stateFrequencyAccumulator.get(state);
        return state.calculatePrize(frequency);
    }

    private void accumulateWinningState(WinningState winningState) {
        this.stateFrequencyAccumulator.put(
                winningState,
                stateFrequencyAccumulator.get(winningState) + 1
        );
    }
}

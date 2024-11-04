package lotto.domain.winner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.common.Price;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.ResultState;

public class WinningStatistic {

    private static final String PROFIT_MESSAGE_TEMPLATE = "총 수익률은 %.1f%%입니다.";
    private static final int INIT_FREQUENCY = 0;
    private static final int INCREASE_VALUE = 1;
    private final Map<ResultState, Integer> stateFrequencyAccumulator = new EnumMap<>(ResultState.class);
    private final double profitRate;

    private WinningStatistic(List<LottoResult> lottoResults, Price price) {
        initialize();
        generateStatistic(lottoResults);
        this.profitRate = calculateProfitRate(price);
    }

    public static WinningStatistic from(List<LottoResult> results, Price price) {
        return new WinningStatistic(results, price);
    }

    public List<WinnerFrequency> getWinnerFrequencies() {
        List<WinnerFrequency> frequencies = new ArrayList<>();
        for (ResultState state : stateFrequencyAccumulator.keySet()) {
            Integer frequency = stateFrequencyAccumulator.get(state);
            frequencies.add(new WinnerFrequency(state, frequency));
        }

        return frequencies;
    }

    public String getFormattedProfitRate() {
        return String.format(PROFIT_MESSAGE_TEMPLATE, profitRate);
    }

    private void initialize() {
        ResultState.winnerStream()
                .forEach(state -> stateFrequencyAccumulator.put(state, INIT_FREQUENCY));
    }

    private void generateStatistic(List<LottoResult> lottoResults) {
        lottoResults.stream()
                .filter(LottoResult::isWinner)
                .map(LottoResult::getState)
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

    private int calculatePrize(ResultState state) {
        Integer frequency = stateFrequencyAccumulator.get(state);
        return state.calculatePrize(frequency);
    }

    private void accumulateWinningState(ResultState resultState) {
        this.stateFrequencyAccumulator.put(
                resultState,
                stateFrequencyAccumulator.get(resultState) + INCREASE_VALUE
        );
    }
}
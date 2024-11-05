package lotto.domain;

import lotto.Lotto;
import lotto.common.LottoGrade;

import java.util.List;
import java.util.Map;

public class EarningReteCalculator {
    private final List<Lotto> buyLots;
    private final Map<LottoGrade, Integer> drawingResults;

    public EarningReteCalculator(List<Lotto> buyLots, Map<LottoGrade, Integer> drawingResults) {
        this.buyLots = buyLots;
        this.drawingResults = drawingResults;
    }

    public Float calculate() {
        float sum = 0F;
        int totalAmount = buyLots.size() * 1000;
        for(Map.Entry<LottoGrade, Integer> entry: drawingResults.entrySet()) {
            sum += entry.getKey().calcAmount(entry.getValue());
        }

        float result = sum / totalAmount * 100;

        return (float) Math.round(result * 100) / 100;
    }

}

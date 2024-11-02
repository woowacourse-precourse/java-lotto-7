package lotto.model;

import java.util.Map;
import lotto.model.constant.LottoRank;

public class LottoStatistics {

    private final Map<LottoRank, Integer> matchedByRank;
    private final double percentRateOfReturn;

    public LottoStatistics(Map<LottoRank, Integer> matchedByRank, double percentRateOfReturn) {
        this.matchedByRank = matchedByRank;
        this.percentRateOfReturn = percentRateOfReturn;
    }

    public Map<LottoRank, Integer> getMatchedByRank() {
        return matchedByRank;
    }

    public double getPercentRateOfReturn() {
        return percentRateOfReturn;
    }
}

package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.model.LottoRank;

public class LottoResultDTO {

    private final Map<LottoRank, Integer> result;
    private final Double profitPercentage;

    public LottoResultDTO(Map<LottoRank, Integer> result, Double profitPercentage) {
        this.result = result;
        this.profitPercentage = profitPercentage;
    }

    public Map<LottoRank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public Double getProfitPercentage() {
        return profitPercentage;
    }
}

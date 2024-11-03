package lotto.dto;

import java.util.Collections;
import java.util.Map;
import lotto.model.LottoRank;

public class LottoResultDTO {

    private final Map<LottoRank, Long> result;
    private final Double profitPercentage;

    public LottoResultDTO(Map<LottoRank, Long> result, Double profitPercentage) {
        this.result = result;
        this.profitPercentage = profitPercentage;
    }

    public Map<LottoRank, Long> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public Double getProfitPercentage() {
        return profitPercentage;
    }
}

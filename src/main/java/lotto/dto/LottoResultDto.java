package lotto.dto;

import java.util.Map;
import lotto.model.domain.LottoPrize;

public class LottoResultDto {
    private Map<LottoPrize, Integer> result;
    private String winningRate;

    public LottoResultDto(Map<LottoPrize, Integer> result, String winningRate) {
        this.result = result;
        this.winningRate = winningRate;
    }

    public Map<LottoPrize, Integer> getResult() {
        return result;
    }

    public void setResult(Map<LottoPrize, Integer> result) {
        this.result = result;
    }

    public String getWinningRate() {
        return winningRate;
    }

    public void setWinningRate(String winningRate) {
        this.winningRate = winningRate;
    }
}

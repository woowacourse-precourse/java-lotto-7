package lotto.dto;

import lotto.domain.LottoRank;

import java.util.Map;

public class WinningResultDto {
    private final Map<LottoRank, Integer> winningResults;
    private final double returnRate;

    public WinningResultDto(Map<LottoRank, Integer> winningResults, double returnRate) {
        this.winningResults = winningResults;
        this.returnRate = returnRate;
    }

    public Map<LottoRank, Integer> getWinningResults() {
        return winningResults;
    }

    public double getReturnRate() {
        return returnRate;
    }
}

package lotto.dto;

import java.util.Map;

public class WinningResultResponse {
    private Map<Integer, Integer> winningResultStatistics;

    public WinningResultResponse(Map<Integer, Integer> winningResultStatistics) {
        this.winningResultStatistics = winningResultStatistics;
    }

    public Map<Integer, Integer> getWinningResultStatistics() {
        return winningResultStatistics;
    }
}

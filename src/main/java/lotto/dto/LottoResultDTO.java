package lotto.dto;

import java.util.List;

public class LottoResultDTO {
    private final List<Integer> winningCounts;
    private final int totalPrize;

    public LottoResultDTO(List<Integer> winningCounts, int totalPrize) {
        this.winningCounts = List.copyOf(winningCounts);
        this.totalPrize = totalPrize;
    }

    public List<Integer> getWinningCounts() {
        return winningCounts;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}

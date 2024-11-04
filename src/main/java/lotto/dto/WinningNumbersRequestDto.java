package lotto.dto;

import java.util.List;

public class WinningNumbersRequestDto {
    private final List<Integer> winningNumbers;

    public WinningNumbersRequestDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}

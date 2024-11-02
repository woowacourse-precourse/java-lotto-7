package lotto.dto;

import java.util.List;

public class WinningNumbersDto {

    private final List<Integer> winningNumber;
    private final Integer winningBonusNumber;

    public WinningNumbersDto(List<Integer> winningNumber, Integer winningBonusNumber) {
        this.winningNumber = winningNumber;
        this.winningBonusNumber = winningBonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getWinningBonusNumber() {
        return winningBonusNumber;
    }

}

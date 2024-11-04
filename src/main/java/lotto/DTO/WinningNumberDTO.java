package lotto.DTO;

import java.util.List;

public class WinningNumberDTO {
    List<Integer> winningNumber;

    public WinningNumberDTO(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}

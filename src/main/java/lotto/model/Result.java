package lotto.model;

import java.util.List;

public class Result {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public Result(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

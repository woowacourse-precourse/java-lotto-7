package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber = new ArrayList<>();
    private final int bonusNumber;

    WinningNumber(List<Integer> userWinningNumbers, int userBonusNumber) {
        winningNumber.addAll(userWinningNumbers);
        this.bonusNumber = userBonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

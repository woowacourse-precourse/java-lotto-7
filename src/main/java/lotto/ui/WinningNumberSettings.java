package lotto.ui;

import java.util.List;

public class WinningNumberSettings {
    private final int bonusNumber;
    private final List<Integer> winningNumber;

    public WinningNumberSettings(int bonusNumber, List<Integer> winningNumber) {
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}

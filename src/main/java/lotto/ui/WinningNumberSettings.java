package lotto.ui;

import java.util.List;

public class WinningNumberSettings {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumberSettings(List<Integer> winningNumber, int bonusNumber) {
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

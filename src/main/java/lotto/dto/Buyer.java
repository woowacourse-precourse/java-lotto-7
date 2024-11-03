package lotto.dto;

import lotto.Utils.Convertor;

import java.util.List;

public class Buyer {
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public Buyer(WinningNumbers winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getwinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

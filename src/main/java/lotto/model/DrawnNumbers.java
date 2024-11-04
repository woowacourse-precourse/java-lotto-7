package lotto.model;

import java.util.Objects;

public class DrawnNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public DrawnNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber.equals(number);
    }
}

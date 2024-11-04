package lotto.domain;

import java.util.List;

public class DrawnNumbers {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public DrawnNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers(){
        return winningNumbers;
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber.equals(number);
    }
}

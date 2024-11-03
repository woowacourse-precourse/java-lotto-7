package lotto.model;

import lotto.util.ValidationUtils;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, WinningNumber winningNumber) {
        ValidationUtils.validateBonusNumber(number, winningNumber.getNumbers());
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

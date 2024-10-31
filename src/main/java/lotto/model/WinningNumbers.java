package lotto.model;

import lotto.Lotto;

public class WinningNumbers {
    private Lotto numbers;
    private int bonusNumber;

    public WinningNumbers(Lotto numbers, int bonusNumber) {
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int number) {
        validateRange(number);
        validateNotWinningNumbers(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotWinningNumbers(int number) {
        if (numbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}

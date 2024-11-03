package lotto.model;

import lotto.util.ValidationUtils;

import java.util.Set;
import java.util.TreeSet;

public class WinningNumber {
    private final Set<Integer> numbers;
    private final BonusNumber bonusNumber;

    public WinningNumber(Set<Integer> numbers, int bonusNumberValue) {
        ValidationUtils.validateWinningNumbers(numbers);
        this.numbers = new TreeSet<>(numbers);
        this.bonusNumber = new BonusNumber(bonusNumberValue, this);
    }

    public Set<Integer> getNumbers() {
        return new TreeSet<>(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}

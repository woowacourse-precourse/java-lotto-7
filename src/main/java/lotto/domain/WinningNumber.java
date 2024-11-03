package lotto.domain;

import java.util.List;

import static lotto.NumbersGenerator.MAX;
import static lotto.NumbersGenerator.MIN;
import static lotto.exception.ExceptionCode.DUPLICATED_NUMBER;
import static lotto.exception.ExceptionCode.NUMBER_OUT_OF_RANGE;

public class WinningNumber {

    private final Lotto numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(numbers, bonusNumber);
        this.numbers = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(Integer bonusNumber) {
        if (bonusNumber < MIN || bonusNumber > MAX) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        }
    }

    private void validateDuplication(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
    }

    public Lotto getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

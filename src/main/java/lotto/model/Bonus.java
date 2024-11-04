package lotto.model;

import lotto.exception.InvalidBonusDuplicateException;
import lotto.exception.InvalidBonusRangeException;

import java.util.List;

import static lotto.constant.Constants.LOTTO_END;
import static lotto.constant.Constants.LOTTO_START;

public class Bonus {
    private final int number;

    public Bonus(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    private void validate(int number, List<Integer> numbers) {
        validateRange(number);
        validateDuplicateNumber(number, numbers);
    }

    private void validateRange(int number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new InvalidBonusRangeException();
        }
    }

    private void validateDuplicateNumber(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new InvalidBonusDuplicateException();
        }
    }

    public int getNumber() {
        return this.number;
    }
}

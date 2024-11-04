package lotto.model;

import java.util.Objects;

import static lotto.exception.ErrorMessages.*;
import static lotto.util.Validator.isEmpty;
import static lotto.util.Validator.isInteger;

public class BonusNumber {
    private final int value;

    public BonusNumber(String value, WinningNumbers winningNumbers) {
        validate(value, winningNumbers);
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(String value, WinningNumbers winningNumbers) {
        if (isEmpty(value)) {
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR);
        }

        if (!isInteger(value) || !isInRange1To45(value)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }

        if (isDuplicateWithWinningNumbers(value, winningNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    private boolean isInRange1To45(String value) {
        int number = Integer.parseInt(value);
        return number > 0 && number < 46;
    }

    private boolean isDuplicateWithWinningNumbers(String value, WinningNumbers winningNumbers) {
        return winningNumbers.contains(Integer.parseInt(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

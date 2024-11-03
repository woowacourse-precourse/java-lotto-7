package lotto.domain.core;

import static lotto.exception.ErrorMessage.*;

public class Bonus {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final int number;

    public Bonus(int number, Lotto lotto) {
        validateRange(number);
        validateNotDuplicate(number, lotto);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNotDuplicate(int number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalStateException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}

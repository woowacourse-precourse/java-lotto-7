package lotto.domain;

import lotto.enums.ErrorMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int ZERO = 0;

    private final int number;

    private BonusNumber(int number) {
        validatePositiveInteger(number);
        validateRange(number);
        this.number = number;
    }

    public static BonusNumber from(final int number) {
        return new BonusNumber(number);
    }

    private void validatePositiveInteger(int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_BONUS_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

    private void validateRange(int number) {
        boolean isValid = (number >= MIN_NUMBER && number <= MAX_NUMBER);

        if (!isValid) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}

package lotto.domain;

import lotto.enums.ErrorMessage;

public class BonusNumber {
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
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_BONUS_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

    private void validateRange(int number) {
        boolean isValid = (number >= 1 && number <= 45);

        if (!isValid) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}

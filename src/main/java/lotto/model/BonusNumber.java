package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;

public record BonusNumber(int value) {
    public static BonusNumber of(int value, Lotto mainNumbers) {
        validate(value, mainNumbers);
        return new BonusNumber(value);
    }

    private static void validate(final int value, final Lotto mainNumbers) {
        validateRange(value);
        validateNotMainNumbers(mainNumbers, value);
    }

    private static void validateRange(final int number) {
        if (number < Rule.MIN_LOTTO_NUMBER || number > Rule.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    private static void validateNotMainNumbers(final Lotto mainNumbers, final int bonusNumber) {
        if (mainNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED_NUMBER.getMessage());
        }
    }
}

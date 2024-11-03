package lotto.util;

import lotto.domain.Lotto;
import lotto.util.message.ErrorMessage;

public class InputValidator {
    private static final int NOT_ALLOWED_AMOUNT= 0;
    private static final int DIVIDE_NUMBER = 1000;
    private static final String INVALID_STRING = " ";
    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 45;

    public static void validateNonEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

    public static void validatePositiveAmount(int amount) {
        if (amount <= NOT_ALLOWED_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_ERROR);
        }
    }

    public static void validateAmountUnit(int amount) {
        if (amount % DIVIDE_NUMBER != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT_ERROR);
        }
    }

    public static void validateNoSpaces(String input) {
        if (input.contains(INVALID_STRING)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_SPACE_ERROR);
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR);
        }
    }

    public static void validateUniqueBonus(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_ERROR);
        }
    }
}

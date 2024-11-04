package lotto.validation;

import static lotto.util.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.util.LottoConstants.MIN_LOTTO_NUMBER;

import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class CommonLottoNumberValidator {
    public static void validateLottoInput(String input) {
        validateNotNullOrEmpty(input);
        validateIsNumber(input);
        validateLottoRange(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(InputErrorMessage.CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputErrorMessage.INTEGER_REQUIRED);
        }
    }

    private static void validateLottoRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < MIN_LOTTO_NUMBER.getValue() || inputNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_RANGE_INVALID);
        }
    }


}

package lotto.validation;

import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;
import lotto.util.Converter;

public class BonusNumberValidator {

    public static void validateBonusNumber(String input) {
        validateNull(input);
        validateStartZero(input);
        validateRange(input);
        validateNumericInput(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateStartZero(String input) {
        if (input.equals("0") || input.matches("^0\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_START_WITH_ZERO.getErrorMessage());
        }
    }

    private static void validateRange(String input) {
        long number = Converter.convertStringToLong(input);
        if (number < LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue() || number > LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ALLOW_ONE_TO_FORTY_FIVE.getErrorMessage());
        }
    }

    private static void validateNumericInput(String input) {
        if (!input.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_WITHOUT_NUMBER.getErrorMessage());
        }
    }
}

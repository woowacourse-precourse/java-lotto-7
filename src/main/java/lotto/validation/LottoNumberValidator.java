package lotto.validation;

import lotto.enums.ErrorMessage;

public class LottoNumberValidator {

    public static void validateLottoNumber(String input) {
        validateNull(input);
        validateSeparatorNotComma(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateSeparatorNotComma(String input) {
        if (!input.contains(",") || !input.matches("^[\\d,\\s]+$")) {
            throw new IllegalArgumentException(ErrorMessage.SEPARATOR_NOT_COMMA.getErrorMessage());
        }
    }
}

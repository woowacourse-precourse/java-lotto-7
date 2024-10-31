package lotto.validation;

import lotto.enums.ErrorMessage;

public class LottoNumberValidator {

    public static void validateLottoNumber(String input) {
        validateNull(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }
}

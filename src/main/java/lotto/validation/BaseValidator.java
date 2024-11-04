package lotto.validation;

import lotto.exception.ErrorMessage;

public class BaseValidator {

    public static void validateBasicAll(final String input){
        validateNull(input);
        validateEmpty(input);
    }

    public static void validateEmpty(final String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_EMPTY_OR_NULL.toString());
        }
    }

    public static void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_EMPTY_OR_NULL.toString());
        }
    }
}

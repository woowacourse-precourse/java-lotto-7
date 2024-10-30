package lotto;

import java.util.Arrays;
import lotto.exception.ExceptionMessages;

public class InputValidator {

    private static final String DIGIT_REGEX = "^[0-9]*$";

    public void validateWhiteSpace(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_WHITESPACE.getMessage());
        }
    }

    public void validateNonDigitInput(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_DIGIT.getMessage());
        }
    }

    public void validateOutOfRangeAmount(String input) {
        long amount = Long.parseLong(input);
        if (amount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }

    public void validateEmptyElemFromInput(String input) {
        String[] splitInput = input.split(",");
        Arrays.stream(splitInput).forEach(elem -> {
            if (elem.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessages.EMPTY_ELEM_EXIST.getMessage());
            }
        });
    }

    public void validateEndsWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ExceptionMessages.ENDS_WITH_COMMA.getMessage());
        }
    }

    public void validateExistNotDigitElems(String input) {
        String[] elems = input.split(",");
        Arrays.stream(elems).forEach(this::validateNonDigitInput);
    }
}

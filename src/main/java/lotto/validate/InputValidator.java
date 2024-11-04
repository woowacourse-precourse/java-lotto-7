package lotto.validate;

import java.util.Arrays;
import lotto.exception.ExceptionMessages;

public class InputValidator {

    private static final String DIGIT_REGEX = "^-?[0-9]*$";
    private static final String INPUT_DELIM = ",";

    public void validateAmountOfMoney(String input) {
        validateWhiteSpace(input);
        validateNonDigitInput(input);
        validateOutOfRangeAmount(input);
    }

    public void validateWinningNumbers(String input) {
        validateWhiteSpace(input);
        validateEmptyElemFromInput(input);
        validateEndsWithComma(input);
        validateExistNotDigitElems(input);
    }

    public void validateBonusNumber(String input) {
        validateWhiteSpace(input);
        validateNonDigitInput(input);
    }

    private void validateWhiteSpace(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_WHITESPACE.getMessage());
        }
    }

    private void validateNonDigitInput(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_DIGIT.getMessage());
        }
    }

    private void validateOutOfRangeAmount(String input) {
        long amount = Long.parseLong(input);
        if (amount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateEmptyElemFromInput(String input) {
        String[] splitInput = input.split(INPUT_DELIM);
        Arrays.stream(splitInput).forEach(elem -> {
            if (elem.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessages.EMPTY_ELEM_EXIST.getMessage());
            }
        });
    }

    private void validateEndsWithComma(String input) {
        if (input.endsWith(INPUT_DELIM)) {
            throw new IllegalArgumentException(ExceptionMessages.ENDS_WITH_COMMA.getMessage());
        }
    }

    private void validateExistNotDigitElems(String input) {
        String[] elems = input.split(INPUT_DELIM);
        Arrays.stream(elems).forEach(elem -> validateNonDigitInput(elem.strip()));
    }
}

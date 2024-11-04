package lotto.validator;

import static lotto.parser.InputParser.parseNumbers;
import static lotto.validator.ValidationMessage.INVALID_WINNING_NUMBERS_FORMAT;

import lotto.exception.InvalidInputException;

public class WinningNumbersValidator {
    public void validate(String inputNumbers) {
        validateNotNull(inputNumbers);
        validateNotEmpty(inputNumbers);
        validateDelimiter(inputNumbers);
    }

    private void validateNotNull(String inputNumbers) {
        if (inputNumbers == null) {
            throw new InvalidInputException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }

    private void validateNotEmpty(String inputNumbers) {
        if (inputNumbers.isEmpty() || inputNumbers.isBlank()) {
            throw new InvalidInputException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }

    private void validateDelimiter(String inputNumbers) {
        try {
            parseNumbers(inputNumbers);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }
}

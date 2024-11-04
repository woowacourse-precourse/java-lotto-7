package lotto.validator;

import static lotto.parser.InputParser.parseInteger;
import static lotto.validator.ValidationMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.validator.ValidationMessage.INVALID_BONUS_NUMBER_FORMAT;

import java.util.List;
import lotto.exception.InvalidInputException;

public class BonusNumberValidator {
    public void validate(String inputNumber, List<Integer> winningNumbers) {
        validateNotNull(inputNumber);
        validateNotEmpty(inputNumber);
        validateIsInteger(inputNumber);
        validateBonusNumberNotInWinningNumbers(inputNumber, winningNumbers);
    }

    private void validateNotNull(String inputNumber) {
        if (inputNumber == null) {
            throw new InvalidInputException(INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateNotEmpty(String inputNumber) {
        if (inputNumber.isEmpty() || inputNumber.isBlank()) {
            throw new InvalidInputException(INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateIsInteger(String inputNumber) {
        try {
            parseInteger(inputNumber);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateBonusNumberNotInWinningNumbers(String inputNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(parseInteger(inputNumber))) {
            throw new InvalidInputException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}

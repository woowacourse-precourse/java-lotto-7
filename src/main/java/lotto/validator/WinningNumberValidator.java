package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.GlobalConstant;

public class WinningNumberValidator {
    private String inputWinningNumbers;
    private String[] winningNumbers;
    private List<Integer> duplicateCheckNumbers;

    private void setValue(String inputWinningNumbers) {
        this.inputWinningNumbers = inputWinningNumbers;
        this.winningNumbers = inputWinningNumbers.split(GlobalConstant.SEPARATOR.value());
        this.duplicateCheckNumbers = new ArrayList<>();
    }

    public void validate(String inputWinningNumbers) {
        setValue(inputWinningNumbers);
        validateBlank();
        validateSeparator();
        validateSize();
        validateEachNumber();
    }

    private void validateSeparator() {
        if (!inputWinningNumbers.contains(GlobalConstant.SEPARATOR.value())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_SEPARATOR_ERROR.toString());
        }
    }

    private void validateBlank() {
        if (inputWinningNumbers.isBlank() || inputWinningNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_BLANK_ERROR.toString());
        }
    }

    private void validateSize() {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_SIZE_ERROR.toString());
        }
    }

    private void validateEachNumber() {
        for (String number : winningNumbers) {
            validateNumeric(number.trim());
            int parseNumber = Integer.parseInt(number);
            validateOutOfRange(parseNumber);
            isDuplicate(parseNumber);
            duplicateCheckNumbers.add(parseNumber);
        }
    }

    private void validateNumeric(String number) {
        if (!number.matches(GlobalConstant.NUMBER_REGEX.value())) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_NON_INTEGER_ERROR.toString());
        }
    }

    private void validateOutOfRange(int parseNumber) {
        if (parseNumber < 1 || parseNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_OUT_OF_RANGE_ERROR.toString());
        }
    }

    private void isDuplicate(int parseNumber) {
        if (duplicateCheckNumbers.contains(parseNumber)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATE_ERROR.toString());
        }
    }
}

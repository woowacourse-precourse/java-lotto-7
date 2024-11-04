package lotto.model.winningnumbers;

import lotto.model.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final String SEPARATOR = ",";

    public String validate(String winningNumbersInput) {
        if (validateNullInput(winningNumbersInput)) {
            return ErrorMessage.EMPTY_INPUT.getMessage();
        }
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
        if (validateDuplicate(winningNumbers)) {
            return ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage();
        }
        if (validateCount(winningNumbers)) {
            return ErrorMessage.INVALID_COUNT.getMessage();
        }
        if (validateRange(winningNumbers)) {
            return ErrorMessage.INVALID_WINNING_NUMBER.getMessage();
        }
        return winningNumbersInput;
    }

    private boolean validateRange(List<Integer> winningNumbers) {
        try {
            for (int number : winningNumbers) {
                checkRange(number);
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private static void checkRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        }
    }

    private boolean validateCount(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateDuplicate(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateNullInput(String winningNumbersInput) {
        try {
            if (winningNumbersInput == null || winningNumbersInput.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

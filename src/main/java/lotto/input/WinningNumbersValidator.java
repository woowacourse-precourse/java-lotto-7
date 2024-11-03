package lotto.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {

    private static final String EMPTY_INPUT_ERROR = "[ERROR] 당첨 번호가 입력되지 않았습니다.";
    private static final String INVALID_COUNT_ERROR = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호에 중복이 있을 수 없습니다.";
    private static final String INVALID_WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.";

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final String SEPARATOR = ",";

    public String validate(String winningNumbersInput) {
        if (validateNullInput(winningNumbersInput)) {
            return EMPTY_INPUT_ERROR;
        }
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
        if (validateDuplicate(winningNumbers)) {
            return DUPLICATE_WINNING_NUMBERS_ERROR;
        }
        if (validateCount(winningNumbers)) {
            return INVALID_COUNT_ERROR;
        }
        if (validateRange(winningNumbers)) {
            return INVALID_WINNING_NUMBER_ERROR;
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
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_ERROR);
        }
    }

    private boolean validateCount(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
                throw new IllegalArgumentException(INVALID_COUNT_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateDuplicate(List<Integer> winningNumbers) {
        try {
            if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
                throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private boolean validateNullInput(String winningNumbersInput) {
        try {
            if (winningNumbersInput == null || winningNumbersInput.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
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

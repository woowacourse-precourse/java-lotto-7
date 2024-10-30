package lotto.validation;

import lotto.view.constant.ErrorConstant;

public class WinningNumbersValidator {
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_OF_WINNING_NUMBERS = 6;

    public void validateWinningNumbers(String winningNumbers) {
        if (!isEntered(winningNumbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_ENTERED);
        if (!hasRightDelimiter(winningNumbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_VALID_DELIMITER);
        if (!isWithinValidRange(winningNumbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_WITHIN_VALID_RANGE);
        if (!isCorrectNumberCount(winningNumbers))
            throw new IllegalArgumentException(ErrorConstant.ERROR_MARK + ErrorConstant.NOT_CORRECT_NUMBER_COUNT);
    }

    private static boolean isEntered(String s) {
        return !s.isEmpty();
    }

    private static boolean hasRightDelimiter(String s) {
        s = eraseBlank(s);
        String[] numbers = s.split(DELIMITER);
        for (String number : numbers) {
            if (!number.matches("^[0-9]+$")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWithinValidRange(String s) {
        String[] numbers = s.split(DELIMITER);
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_NUMBER || Integer.parseInt(number) > MAX_NUMBER)
                return false;
        }
        return true;
    }

    private static boolean isCorrectNumberCount(String s) {
        String[] numbers = s.split(DELIMITER);
        return numbers.length == NUMBER_OF_WINNING_NUMBERS;
    }

    private static String eraseBlank(String s) {
        return s.replace(" ", "");
    }
}

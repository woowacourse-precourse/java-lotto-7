package lotto.validation;

import java.util.List;
import lotto.exception.ErrorMessage;

public class WinningNumberValidator extends BaseValidator{

    public static void validateBetweenDelimiter(String input) {
        String[] winningNumbers = input.split(",",-1); // -1을 limit으로 넣어주어 문자열의 마지막이 구분자인 경우도 검출
        for (String number: winningNumbers){
            throwIfEmpty(number.trim().isEmpty());
        }
    }

    private static void throwIfEmpty(boolean state){
        if (state){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER.toString());
        }
    }

    public static void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_NUMBERS_NOT_SIX.toString());
        }
    }

    public static void validateDelimiter(String input) {
        // 쉼표(,)로 나누었을 때, 쉼표와 숫자 이외의 문자가 포함되어 있으면 예외 처리
        if (!input.replaceAll(" ","").matches("[0-9,]+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DELIMITER_ONLY_COMMA.toString());
        }
    }

    public static void validateOnlyNumeric(String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_NUMBER_NOT_NUMERIC.toString());
        }
    }

    private static boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public static void validateWinningNumberDuplicate(List<Integer> winningNumbers, int inputNumber) {
        for (int winningNumber: winningNumbers){
            validateDuplicate(inputNumber,winningNumber);
        }
    }

    private static void validateDuplicate(int inputNumber, int winningNumber) {
        if (winningNumber==inputNumber){
            throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_NUMBER_DUPLICATE.toString());
        }
    }

    public static void validateNumberRange(int winningNumber) {
        if (winningNumber<1 || winningNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE.toString());
        }
    }
}

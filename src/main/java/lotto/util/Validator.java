package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorMessage;

public class Validator {

    public static void isEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERR_EMPTY_INPUT.getMessage());
        }
    }

    public static void isDigitString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.ERR_IS_NOT_DIGIT_STRING.getMessage());
            }
        }
    }

    public static void isNumberWithinRange(int number, int minNumber, int maxNumber) {
        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static int isInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERR_IS_NOT_INTEGER_RANGE.getMessage());
        }
    }

    public static void isDivisibleBy(int number, int divisor) {
        if ((number % divisor) != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERR_IS_NOT_DIVISIABLE_INPUT.getMessage());
        }
    }

    public static <T> void isEqualListSize(List<T> list, int winningNumberCount) {
        if (list.size() != winningNumberCount) {
            throw new IllegalArgumentException(ErrorMessage.ERR_IS_NOT_SAME_WITH_LIST_SIZE.getMessage());
        }
    }

    public static <T> void isNotDuplicate(List<T> inputs) {
        Set<T> uniqueNumbers = new HashSet<>();
        for (T input : inputs) {
            if (!uniqueNumbers.add(input)) {
                throw new IllegalArgumentException(ErrorMessage.ERR_IS_DUPLICATED.getMessage());
            }
        }
    }

    public static <T> void isNotInList(List<T> list, T input) {
        if (list.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERR_IS_DUPLICATED.getMessage());
        }
    }
}

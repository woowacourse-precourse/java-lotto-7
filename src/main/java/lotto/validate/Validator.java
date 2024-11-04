package lotto.validate;

import lotto.constants.AppConst;
import lotto.constants.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Validator {

    public static int validateParsingToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    public static void validateDividedByUnit(int num) {
        if (isNotDivided(num)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ABLE_TO_PURCHASE);
        }
    }

    public static String[] validationDelimiter(String num) {
        if (!num.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER);
        }
        return num.split(",");
    }

    public static int validationInRange(int num) {
        if (!isValidInRange(num)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
        return num;
    }

    public static List<Integer> validationDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE);
        }
        return numbers;
    }

    public static void validationSize(List<Integer> validatedList) {
        if (validatedList.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_SIZE);
        }
    }

    private static boolean isNotDivided(int num) {
        return num <= 0 || num % AppConst.DIVISION_UNIT != 0;
    }

    private static boolean isValidInRange(int num) {
        return 1 <= num && num <= 45;
    }
}

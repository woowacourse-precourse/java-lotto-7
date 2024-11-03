package lotto.Vaildator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.ErrorMessage;

public class InputValidator {

    public static void valid(List<Integer> numbers) {
        validSize(numbers);
        validRange(numbers);
    }

    public static void validInput(String input) {
        validEmpty(input);
        validNum(input);
        validDuplicate(input);
    }

    private static void validSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorMessage.printError(ErrorMessage.SIZE_ERROR);
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR);
        }
    }

    public static void validBonus(String bonus) {
        validEmpty(bonus);
        if (!isNumeric(bonus)) {
            ErrorMessage.printError(ErrorMessage.NON_NUMERIC_ERROR);
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ERROR);
        }
        int bonusNumber = Integer.parseInt(bonus.trim());
        if (!isRange(bonusNumber)) {
            ErrorMessage.printError(ErrorMessage.BONUS_RANGE_ERROR);
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE_ERROR);
        }
    }

    public static void bonusDuple(int bonusNumber, List<Integer> winningNumbers) {
        for (int num : winningNumbers) {
            if (num == bonusNumber) {
                ErrorMessage.printError(ErrorMessage.BONUS_DUPLICATE_ERROR);
                throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_ERROR);
            }
        }
    }

    private static List<String> parseInput(String input) {
        String[] splitNumbers = input.split(",");
        List<String> numbers = new ArrayList<>();
        for (String number : splitNumbers) {
            numbers.add(number.trim());
        }
        return numbers;
    }

    private static void validEmpty(String input) {
        for (String number : parseInput(input)) {
            if (isEmpty(number)) {
                ErrorMessage.printError(ErrorMessage.EMPTY_VALUE_ERROR);
                throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE_ERROR);
            }
        }
    }

    private static void validNum(String input) {
        for (String number : parseInput(input)) {
            String trimmedNumber = number.trim();
            if (!trimmedNumber.matches("\\d+")) {
                ErrorMessage.printError(ErrorMessage.NON_NUMERIC_ERROR);
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ERROR);
            }
        }
    }

    private static void validDuplicate(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : parseInput(input)) {
            numbers.add(Integer.parseInt(number.trim()));
        }
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            ErrorMessage.printError(ErrorMessage.DUPLICATE_NUMBER_ERROR);
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR);
        }
    }

    private static void validRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (!isRange(num)) {
                ErrorMessage.printError(ErrorMessage.RANGE_ERROR);
                throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR);
            }
        }
    }

    private static boolean isRange(int num) {
        return num >= 1 && num <= 45;
    }

    public static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    public static boolean isEmpty(String input) {
        String trimmedInput = input.trim();
        return trimmedInput.isEmpty();
    }

}
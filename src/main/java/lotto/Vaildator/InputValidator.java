package lotto.Vaildator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.ErrorMessage;

public class InputValidator {
    public static void validInput(String input) {
        isEmpty(input);
        isNum(input);
        validDuplicate(input);
    }

    private static void isNum(String input) {
        for (String number : parseInput(input)) {
            String trimmedNumber = number.trim();
            if (!trimmedNumber.matches("\\d+")) {
                ErrorMessage.printError(ErrorMessage.NON_NUMERIC_ERROR);
                throw new NumberFormatException(ErrorMessage.NON_NUMERIC_ERROR);
            }
        }
    }

    public static void validBonus(String bonus) {
        isEmpty(bonus);
        isNumeric(bonus);
        int bonusNumber = Integer.parseInt(bonus.trim());
        isRange(bonusNumber);
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

    public static void emptyContain(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) {
                ErrorMessage.printError(ErrorMessage.EMPTY_VALUE_ERROR);
                throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE_ERROR);
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


    private static void isRange(int num) {
        if (num < 1 || num > 45) {
            ErrorMessage.printError(ErrorMessage.RANGE_ERROR);
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR);
        }
    }

    public static void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            ErrorMessage.printError(ErrorMessage.NON_NUMERIC_ERROR);
            throw new NumberFormatException(ErrorMessage.NON_NUMERIC_ERROR);
        }
    }

    public static void isEmpty(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.isEmpty()) {
            ErrorMessage.printError(ErrorMessage.EMPTY_VALUE_ERROR); // 메시지 출력
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE_ERROR); // 예외 발생
        }
    }

    public static void validPay(int amount) {
        if (amount == 0) {
            ErrorMessage.printError(ErrorMessage.PAY_ZERO); // 메시지 출력
            throw new ArithmeticException(ErrorMessage.PAY_ZERO); // 예외 발생
        }
        if (amount % 1000 != 0) {
            ErrorMessage.printError(ErrorMessage.PAY_ERROR); // 메시지 출력
            throw new IllegalArgumentException(ErrorMessage.PAY_ERROR); // 예외 발생
        }
    }
}
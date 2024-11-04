package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validatedPurchaseAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ValidationType.EMPTY_AMOUNT.validationMsg());
        }
        // 숫자가 아닌 경우 체크
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ValidationType.NOT_NUMERIC.validationMsg());
        }
    }

    public static int validatedThousandUnitAmount(String input) {
        int inputResult;
        try {
            inputResult = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationType.NOT_NUMERIC.validationMsg());
        }
        if (inputResult < 1000) {
            throw new IllegalArgumentException(ValidationType.NEGATIVE_AMOUNT.validationMsg());
        }
        if (inputResult % 1000 != 0) {
            throw new IllegalArgumentException(ValidationType.INVALID_UNIT.validationMsg());
        }
        return inputResult;
    }


    public static void validatedWinnigNumbers(List<Integer> winningNumbers) {
        Set<Integer> numberSet = new HashSet<>();
        validatedWinningNumbers(winningNumbers);
        for (Integer number : winningNumbers) {
            outOfRangeWinningNumber(number);
            duplicateWinningNumber(number, numberSet);
        }
    }
    public static void validateWinningNumberFormat(String winningNumber) {
        String regex ="^(\\d{1,2})(,\\d{1,2}){5}$";
        if (!winningNumber.matches(regex)) {
            throw new IllegalArgumentException(ValidationType.INVALID_FORMAT.validationMsg());
        }
    }

    public static void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers); // List를 Set으로 변환하여 중복 제거
        if (numberSet.size() != numbers.size()) { // 중복이 있을 경우
            throw new IllegalArgumentException(ValidationType.DUPLICATE_LOTTO.validationMsg());
        }
    }

    private static void validatedWinningNumbers(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == 6)) {
            throw new IllegalArgumentException(ValidationType.INVALID_COUNT.validationMsg());
        }
    }

    private static void outOfRangeWinningNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ValidationType.OUT_OF_RANGE.validationMsg());
        }
    }

    private static void duplicateWinningNumber(Integer number, Set<Integer> numberSet) {
        if (!numberSet.add(number)) {
            throw new IllegalArgumentException(ValidationType.DUPLICATE_NUMBERS.validationMsg());
        }
    }
}

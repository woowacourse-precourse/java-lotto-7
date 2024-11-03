package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validatePurchaseAmount(String input) {
        validateNotEmpty(input);
        validateIsNumeric(input);
        validatePositiveAmount(input);
        validateThousandUnit(input);
    }

    public static void validateWinningNumber(String input) {
        validateWinningNumberFormat(input);
        validateWinningNumberRange(input);
        validateNoDuplicateWinningNumbers(input);
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateIsNumeric(input);
        validateBonusNumberRange(input);
        validateBonusNumberNotInWinningNumbers(input, winningNumbers);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어 있을 수 없습니다.");
        }
    }

    private static void validateIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
        }
    }

    private static void validatePositiveAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 0보다 커야 합니다.");
        }
    }

    private static void validateThousandUnit(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력값은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateWinningNumberFormat(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 구성되어야 하며, 콤마로 구분되어야 합니다.");
        }
    }

    private static void validateWinningNumberRange(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            validateIsNumeric(number);
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }


    private static void validateNoDuplicateWinningNumbers(String input) {
        Set<Integer> numberSet = new HashSet<>();
        String[] numbers = input.split(",");

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (!numberSet.add(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자가 있을 수 없습니다.");
            }
        }
    }

    private static void validateBonusNumberRange(String input) {
        int bonusNum = Integer.parseInt(input);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateBonusNumberNotInWinningNumbers(String input, List<Integer> winningNumbers) {
        int bonusNum = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}

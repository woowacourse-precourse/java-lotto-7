package lotto;

import java.util.List;

public class Validator {
    public static void validateMoneyInput(String userInput) {
        validateNotEmpty(userInput);
        int moneyInput = validateNumberInput(userInput);
        validateDivisibilityBy1000(moneyInput);
    }

    private static void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static int validateNumberInput(String userInput) {
        try {
            int userIntInput = Integer.parseInt(userInput);

            if (userIntInput < 0) {
                throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
            }

            return userIntInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static void validateDivisibilityBy1000(int userInput) {
        if (userInput % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static void validateNotEmpty(String userInput) {
        if (userInput.isEmpty() || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력할 수 없습니다.");
        }
    }
}

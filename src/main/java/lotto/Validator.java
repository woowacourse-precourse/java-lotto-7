package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static int validateMoneyInput(String userInput) {
        validateNotEmptyValue(userInput);
        int moneyInput = validateNumberInput(userInput);
        validateDivisibilityBy1000(moneyInput);

        return moneyInput;
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumberRange(number);
        }
        validateNumberOfNumbers(numbers);
        validateUniqueNumbers(numbers);
    }

    public static int validateLottoNumber(String userInput) {
        validateNotEmptyValue(userInput);
        return validateNumberInput(userInput);
    }

    public static void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
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

    private static void validateNotEmptyValue(String userInput) {
        if (userInput.isEmpty() || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력할 수 없습니다.");
        }
    }

    private static void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45 입니다.");
        }
    }

    private static void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
}

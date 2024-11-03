package lotto.validator;

import java.util.List;

public class LottoBonusNumbersValidator {
    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateInputNotEmpty(input);
        int bonusNumber = parseBonusNumber(input);
        validateBonusNumber(bonusNumber);
        validateBonusNumberNotInWinningNumbers(bonusNumber, winningNumbers);
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateInputNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있을 수 없습니다.");
        }
    }

    private static int parseBonusNumber(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
        }
        try {
            return Integer.parseInt(numbers[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.");
        }
    }

    private static void validateBonusNumberNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}

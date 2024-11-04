package lotto;

import java.util.List;

public class BonusNumberValidator {

    public static int validate(String input, List<Integer> winningNumbers) {
        validateNullOrEmpty(input);
        int bonusNumber = parseNumber(input);
        validateRange(bonusNumber);
        validateNoDuplication(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 입력이 null입니다.");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 정수여야함.");
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 정수여야함.");
        }
    }

    private static void validateNoDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}

package lotto.utils;

import java.util.List;

public class BonusNumberValidator {

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        validateIsNumeric(bonusNumber);
        validateInRange(bonusNumber);
        validateNotDuplicateWithWinningNumbers(bonusNumber, winningNumbers);
    }

    private static void validateIsNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void validateInRange(String number) {
        int num = Integer.parseInt(number);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45 사이여야 합니다.");
        }
    }

    private static void validateNotDuplicateWithWinningNumbers(String number, List<Integer> winningNumbers) {
        int bonusNum = Integer.parseInt(number);
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}

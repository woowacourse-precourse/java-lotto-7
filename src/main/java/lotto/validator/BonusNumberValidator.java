package lotto.validator;

import java.util.List;

public class BonusNumberValidator {

    // 보너스 번호가 1부터 45 사이인지 검증
    public static void validateBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 보너스 번호가 당첨 번호와 중복되지 않는지 검증
    public static void validateBonusNumberNotDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    // 보너스 번호가 숫자인지 검증 (필요시 사용)
    public static void validateBonusNumberIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}


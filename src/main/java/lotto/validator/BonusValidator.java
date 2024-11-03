package lotto.validator;

import java.util.List;

public class BonusValidator {

    public static void validateBonusInputNotNull(String bonusInput) {
        if (bonusInput == null || bonusInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스번호를 입력해야 합니다.");
        }
    }

    public static void validateBonusIsNumeric(String bonusInput) {
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }

    }

    public static void validateBonusNumberRange(int bonus) {
        if (bonus <1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateBonusNotDuplicated(List<Integer> winningNumbers, int bonus) {
        for (Integer number : winningNumbers) {
            if (number == bonus) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 보너스 번호와 중복되지 않아야 한다.");
            }
        }
    }

}

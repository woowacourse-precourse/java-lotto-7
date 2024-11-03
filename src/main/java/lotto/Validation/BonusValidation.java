package lotto.Validation;

import java.util.List;

public class BonusValidation {

    public static void BonusInputNotNull(String BonusInput) {
        if (BonusInput == null || BonusInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해야 합니다.");
        }
    }

    public static void BonusIsNumeric(String BonusInput) {
        if (!BonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }

    }

    public static void BonusRange(int bonus) {
        if (bonus <1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");
        }
    }

    public static void BonusNotDuplicate(List<Integer> Numbers, int bonus) {
        for (Integer number : Numbers) {
            if (number == bonus) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");
            }
        }
    }

}
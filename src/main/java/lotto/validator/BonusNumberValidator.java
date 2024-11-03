package lotto.validator;

import lotto.domain.Lotto;

public class BonusNumberValidator {
    private BonusNumberValidator() {
    }

    public static void isNumeric(String bonusNumber) {
        try {
            int bonus = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
    }

    public static void validateNumberRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus <= 0 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

    public static void checkBonusNumberDuplicate(String bonusNumber, Lotto winningNumbers) {
        int bonus = Integer.parseInt(bonusNumber);
        if (winningNumbers.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }
}

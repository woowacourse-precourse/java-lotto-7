package lotto.domain.validator;

import lotto.domain.Lotto;

public class BonusValidator {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    private static final int BONUS_MIN_NUMBER = 1;
    private static final int BONUS_MAX_NUMBER = 45;

    private BonusValidator() {
    }

    public static void validate(String invalidBonus, Lotto lotto) {
        validatePositiveNumber(invalidBonus);
        int bonus = parseMoneyToInteger(invalidBonus);
        validateRange(bonus);
        validateAlreadyExist(bonus, lotto);
    }

    private static void validatePositiveNumber(String invalidBonus) {
        if (!invalidBonus.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 양수만 입력이 가능합니다.");
        }
    }

    private static int parseMoneyToInteger(String invalidBonus) {
        try {
            return Integer.parseInt(invalidBonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 2,147,483,647보다 클 수 없습니다.");
        }
    }

    private static void validateRange(int bonus) {
        if (bonus < BONUS_MIN_NUMBER || bonus > BONUS_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1-45 사이의 숫자만 가능합니다.");
        }
    }

    private static void validateAlreadyExist(int bonus, Lotto lotto) {
        if (lotto.isExist(bonus)) {
            throw new IllegalArgumentException("[ERROR] 이미 로또 번호로 사용된 번호입니다.");
        }
    }
}

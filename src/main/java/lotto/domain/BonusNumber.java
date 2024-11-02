package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;

import lotto.exception.LottoException;

public class BonusNumber {
    private final int bonus;

    private BonusNumber(int bonus) {
        this.bonus = bonus;
    }

    public static BonusNumber from(int bonus) {
        validateRange(bonus);
        return new BonusNumber(bonus);
    }

    private static void validateRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new LottoException(INVALID_BONUS_NUMBER_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonus;
    }
}

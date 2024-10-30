package lotto.input;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

public class Bonus {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int bonus;

    public Bonus(Lotto lotto, int bonus) {
        validateBonusNumber(bonus);
        validate(lotto, bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    private void validateBonusNumber(int bonus) {
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }
}

package lotto.input;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;

public class Bonus {

    private final int bonus;

    public Bonus(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }
}

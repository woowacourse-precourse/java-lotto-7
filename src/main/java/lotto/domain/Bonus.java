package lotto.domain;

import lotto.exception.BonusExceptionType;

public class Bonus {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private final int bonus;

    public Bonus(int bonus) {
        validateRange(bonus);
        this.bonus = bonus;
    }

    private void validateRange(int bonus) throws IllegalArgumentException {
        if (bonus < MINIMUM_NUMBER || bonus > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(BonusExceptionType.OUT_OF_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    public int getBonus() {
        return bonus;
    }
}

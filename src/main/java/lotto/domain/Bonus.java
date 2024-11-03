package lotto.domain;

import lotto.domain.validator.BonusValidator;

public class Bonus {

    private final int bonus;

    public Bonus(String invalidBonus, Lotto lotto) {
        BonusValidator.validate(invalidBonus, lotto);
        this.bonus = Integer.parseInt(invalidBonus);
    }

    public int getBonus() {
        return this.bonus;
    }
}

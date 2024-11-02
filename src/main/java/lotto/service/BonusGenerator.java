package lotto.service;

import lotto.Factory.BonusFactory;
import lotto.domain.Bonus;

public class BonusGenerator {

    private final Bonus bonus;

    public BonusGenerator(String bonus) {
        this.bonus = BonusFactory.create(change(bonus));
    }

    private Integer change(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public Bonus getBonus() {
        return bonus;
    }
}

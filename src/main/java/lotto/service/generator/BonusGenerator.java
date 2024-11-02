package lotto.service.generator;

import lotto.factory.BonusFactory;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class BonusGenerator {

    private final Bonus bonus;

    public BonusGenerator(Lotto winning, String bonus) {
        Integer newBonus = change(bonus);
        validate(winning, newBonus);
        this.bonus = BonusFactory.create(newBonus);
    }

    private Integer change(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicateWinning(Lotto winning, Integer bonus) {
        return winning.getNumbers().contains(bonus);
    }

    private void validate(Lotto winning, Integer bonus) {
        if (duplicateWinning(winning, bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public Bonus getBonus() {
        return bonus;
    }
}

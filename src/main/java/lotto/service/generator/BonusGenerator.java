package lotto.service.generator;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.util.ValidateNumber;

public class BonusGenerator {

    private final Bonus bonus;

    private BonusGenerator(Lotto winning, String bonus) {
        Integer newBonus = ValidateNumber.change(bonus);
        validate(winning, newBonus);
        this.bonus = Bonus.create(newBonus);
    }

    public static BonusGenerator create(Lotto winning, String bonus) {
        return new BonusGenerator(winning, bonus);
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

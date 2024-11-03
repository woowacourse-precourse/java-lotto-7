package lotto.service.generator;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.exception.BonusException;
import lotto.factory.BonusFactory;
import lotto.message.ExceptionMessage;
import lotto.util.NumberValidator;

public class BonusGenerator {

    private final Integer bonus;

    public BonusGenerator(Lotto winning, String bonus) {
        Integer newBonus = NumberValidator.change(bonus);
        validate(winning, newBonus);
        this.bonus = newBonus;
    }

    private boolean duplicateWinning(Lotto winning, Integer bonus) {
        return winning.getNumbers().contains(bonus);
    }

    private void validate(Lotto winning, Integer bonus) {
        if (duplicateWinning(winning, bonus)) {
            throw new BonusException(ExceptionMessage.INPUT_BONUS_DUPLICATION_EXCEPTION);
        }
    }

    public Bonus getBonus() {
        return BonusFactory.create(bonus);
    }
}

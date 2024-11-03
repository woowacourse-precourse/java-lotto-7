package lotto.view.validator.bonus;

import static lotto.error.ErrorMessage.DUPLICATE_BONUS;

import lotto.model.lotto.Lotto;
import lotto.utils.PreProcessor;
import lotto.view.validator.InputValidator;

public class BonusDuplicateValidator extends InputValidator {

    private final Lotto lotto;

    private BonusDuplicateValidator(final Lotto lotto) {
        this.lotto = lotto;
    }

    public static BonusDuplicateValidator initiate(Lotto lotto) {
        return new BonusDuplicateValidator(lotto);
    }

    @Override
    public void validate(String input) {
        Integer number = PreProcessor.stringToInteger(input);
        if (lotto.hasBonus(number)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS.getMessage());
        }
    }
}

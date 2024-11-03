package view.validator.bonus;

import model.lotto.Lotto;
import view.PreProcessor;
import view.validator.InputValidator;

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
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되어서는 안됩니다.");
        }
    }
}

package lotto.io.validator.bonus;

import static java.util.Objects.isNull;
import static lotto.io.exception.EmptyInputException.emptyBonusNumber;

import lotto.io.validator.InputValidator;

public class BonusNumberNullValidator extends InputValidator {

    private BonusNumberNullValidator() {
    }

    public static BonusNumberNullValidator initiate() {
        return new BonusNumberNullValidator();
    }

    @Override
    public void check(final String source) {
        if (isNull(source) || source.isEmpty() || source.isBlank()) {
            throw emptyBonusNumber();
        }
        super.check(source);
    }
}

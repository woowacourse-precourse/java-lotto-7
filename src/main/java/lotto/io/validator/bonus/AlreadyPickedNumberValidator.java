package lotto.io.validator.bonus;

import static lotto.io.exception.AlreadyPickedNumberException.alreadyPicked;

import lotto.io.preprocessor.IOPreprocessor;
import lotto.io.validator.InputValidator;
import lotto.model.lotto.Lotto;

public class AlreadyPickedNumberValidator extends InputValidator {

    private final Lotto lotto;

    public AlreadyPickedNumberValidator(final Lotto lotto) {
        this.lotto = lotto;
    }

    public static AlreadyPickedNumberValidator from(final Lotto lotto) {
        return new AlreadyPickedNumberValidator(lotto);
    }

    @Override
    public void check(final String source) {
        Integer number = IOPreprocessor.stringToInteger(source);
        if (lotto.has(number)) {
            throw alreadyPicked();
        }
        super.check(source);
    }
}

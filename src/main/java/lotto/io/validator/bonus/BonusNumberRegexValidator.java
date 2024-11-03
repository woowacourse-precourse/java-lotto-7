package lotto.io.validator.bonus;

import static lotto.exception.InvalidRangeException.invalidLottoNumberRange;
import static lotto.io.error.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.io.validator.regex.RegexPattern.NUMBER_RANGE;

import java.util.regex.Matcher;
import lotto.io.validator.InputValidator;

public class BonusNumberRegexValidator extends InputValidator {

    private BonusNumberRegexValidator() {
    }

    public static BonusNumberRegexValidator initiate() {
        return new BonusNumberRegexValidator();
    }

    @Override
    public void check(final String source) {
        if (isNotValid(source)) {
            throw invalidLottoNumberRange(INVALID_LOTTO_NUMBER_RANGE);
        }
        super.check(source);
    }

    private boolean isNotValid(final String source) {
        Matcher matcher = NUMBER_RANGE.matcher(source);
        return !matcher.matches();
    }
}

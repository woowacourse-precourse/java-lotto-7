package lotto.io.validator.lotto;

import static lotto.exception.InvalidRangeException.invalidLottoNumberRange;
import static lotto.io.error.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.io.validator.regex.RegexPattern.NUMBER_RANGE;

import java.util.List;
import java.util.regex.Matcher;
import lotto.io.preprocessor.IOPreprocessor;
import lotto.io.validator.InputValidator;

public class LottoRegexValidator extends InputValidator {

    private LottoRegexValidator() {
    }

    public static LottoRegexValidator initiate() {
        return new LottoRegexValidator();
    }

    @Override
    public void check(final String source) {
        List<String> sources = IOPreprocessor.stringToListString(source);
        boolean matched = sources.stream().anyMatch(this::isNotValid);
        if (matched) {
            throw invalidLottoNumberRange(INVALID_LOTTO_NUMBER_RANGE);
        }

        super.check(source);
    }

    private boolean isNotValid(final String source) {
        Matcher matcher = NUMBER_RANGE.matcher(source);
        return !matcher.matches();
    }
}

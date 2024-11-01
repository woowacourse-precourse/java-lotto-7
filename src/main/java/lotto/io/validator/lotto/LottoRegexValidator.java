package lotto.io.validator.lotto;

import static lotto.io.error.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.io.exception.InvalidRangeException.invalidLottoNumberRange;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.io.preprocessor.IOPreprocessor;
import lotto.io.validator.InputValidator;

public class LottoRegexValidator extends InputValidator {

    private static final Pattern regexPattern = Pattern.compile("^([1-9]|[1-3][0-9]|4[1-5])$");

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
        Matcher matcher = regexPattern.matcher(source);
        return !matcher.matches();
    }
}

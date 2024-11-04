package lotto.io.validator.money;

import static lotto.io.error.ErrorMessage.FAILED_PARSING_TO_LONG;
import static lotto.io.exception.StringToLongParsingException.failedParsing;

import lotto.io.validator.InputValidator;

public class MoneyParsingValidator extends InputValidator {

    private MoneyParsingValidator() {
    }

    public static MoneyParsingValidator initiate() {
        return new MoneyParsingValidator();
    }

    @Override
    public void check(final String source) {
        tryParseToLongFrom(source);
        super.check(source);
    }

    private void tryParseToLongFrom(final String source) {
        try {
            Long.parseLong(source);
        } catch (IllegalArgumentException e) {
            throw failedParsing(FAILED_PARSING_TO_LONG);
        }
    }
}

package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class BonusNumber {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");
    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 45;

    private int number;

    public BonusNumber(final String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    private void validate(final String number) {
        validateNumberPattern(number);
        validateValue(number);
    }

    private void validateNumberPattern(final String number) {
        if (!numberPattern.matcher(number).matches()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage()
            );
        }
    }

    private void validateValue(final String number) {
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < LOWER_LIMIT || parsedNumber > UPPER_LIMIT) {
            throw new IllegalStateException(
                    DomainExceptionMessage.INVALID_BONUS_NUMBER_VALUE.getMessage()
            );
        }
    }
}

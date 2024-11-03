package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class BonusNumber {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");
    private int number;

    public BonusNumber(String number) {
        validateNumberPattern(number);
        this.number = Integer.parseInt(number);
    }

    private void validateNumberPattern(final String number) {
        if (!numberPattern.matcher(number).matches()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage()
            );
        }
    }
}

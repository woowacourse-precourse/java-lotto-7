package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class LottoNumber {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");
    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 45;

    private final int number;

    public LottoNumber(final String number) {
        String strip = number.strip();
        validate(strip);
        this.number = Integer.parseInt(strip);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LottoNumber lottoNumber)) {
            return false;
        }
        return this.number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    private void validate(final String number) {
        validateNumberPattern(number);
        validateValue(number);
    }

    private void validateNumberPattern(final String number) {
        if (!numberPattern.matcher(number).matches()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_NUMBER_FORMAT.getMessage()
            );
        }
    }

    private void validateValue(final String number) {
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < LOWER_LIMIT || parsedNumber > UPPER_LIMIT) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_NUMBER_VALUE.getMessage()
            );
        }
    }
}

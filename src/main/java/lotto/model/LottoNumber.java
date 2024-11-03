package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class LottoNumber {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");

    private final int number;

    public LottoNumber(final String number) {
        this.number = Integer.parseInt(number);
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

    private void validateNumberPattern(final String number) {
        if (!numberPattern.matcher(number).matches()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_NUMBER_FORMAT.getMessage()
            );
        }
    }
}

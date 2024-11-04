package lotto.domain.Lotto;

import static lotto.domain.Lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.util.InputParser.parseInt;

public class Number {
    private final static String INVALID_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1에서 45 사이어야 합니다.";
    private final int value;

    public Number(final int value) {
        validate(value);
        this.value = value;
    }

    public Number(final String input) {
        validate(parseInt(input));
        this.value = parseInt(input);
    }

    private void validate(int value) {
        validateNumberRange(value);
    }

    private void validateNumberRange(int value) {
        if (isNotValidRange(value)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidRange(int value) {
        return value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Number number = (Number) obj;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    public int getValue() {
        return value;
    }
}

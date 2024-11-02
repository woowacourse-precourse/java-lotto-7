package lotto.model.domain;

import java.util.Objects;
import lotto.model.ErrorMessage;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof LottoNumber)) return false;

        LottoNumber other = (LottoNumber) obj;
        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

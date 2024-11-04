package lotto.domain;

import java.util.Objects;
import lotto.common.LottoNumbers;
import lotto.exception.LottoArgumentException;

public class LottoNumber {
    private final int number;

    public LottoNumber(final String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    public LottoNumber(final int number) {
        final String value = String.valueOf(number);
        validate(value);
        this.number = number;
    }

    private void validate(final String lottoNumber) {
        this.validateLength(lottoNumber);
        this.validateRange(lottoNumber);
    }

    private void validateRange(final String lottoNumber) {
        final int number = Integer.parseInt(lottoNumber);
        if (number < LottoNumbers.START.get() || number > LottoNumbers.END.get()) {
            throw new LottoArgumentException(
                    "로또 숫자는 " + LottoNumbers.START.get() + "에서 " + LottoNumbers.END.get() + " 까지 입니다.");
        }
    }

    private void validateLength(final String lottoNumber) {
        if (lottoNumber.length() > 2) {
            throw new LottoArgumentException("로또숫자는 세자리 이상이 될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNumber lottoNum = (LottoNumber) object;
        return number == lottoNum.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

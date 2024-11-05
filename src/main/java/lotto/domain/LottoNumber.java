package lotto.domain;

import java.util.Objects;
import lotto.common.LottoNumbers;
import lotto.exception.LottoArgumentException;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final String RANGE_ERROR_FORMAT = "로또 숫자는 %d에서 %d 까지 입니다.";
    private static final String SIZE_ERROR_MESSAGE = "로또숫자는 세자리 이상이 될 수 없습니다.";
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
                    String.format(RANGE_ERROR_FORMAT, LottoNumbers.START.get(), LottoNumbers.END.get())
            );
        }
    }

    private void validateLength(final String lottoNumber) {
        if (lottoNumber.length() > 2) {
            throw new LottoArgumentException(SIZE_ERROR_MESSAGE);
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}

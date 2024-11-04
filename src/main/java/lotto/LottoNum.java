package lotto;

import java.util.Objects;
import lotto.common.LottoNumber;
import lotto.exception.LottoArgumentException;

public class LottoNum {
    private final int number;

    public LottoNum(final String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    public LottoNum(final int number) {
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
        if (number < LottoNumber.START.getNumber() || number > LottoNumber.END.getNumber()) {
            throw new LottoArgumentException(
                    "로또 숫자는 " + LottoNumber.START.getNumber() + "에서 " + LottoNumber.END.getNumber() + " 까지 입니다.");
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
        LottoNum lottoNum = (LottoNum) object;
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

package lotto.model.number;

import lotto.model.exception.LottoNumberInvalidException;

public class LottoNumber {

    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validateNumber(number);
        return new LottoNumber(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            String detail = String.format("로또 번호의 범위는 %d부터 %d까지 입니다.", MIN_NUMBER, MAX_NUMBER);
            throw LottoNumberInvalidException.lottoNumberRange(detail);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

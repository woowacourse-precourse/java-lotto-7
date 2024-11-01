package lotto.model;

import lotto.model.exception.LottoNumberInvalidException;

public class LottoNumber {

    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        validate(number);
        return new LottoNumber(number);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw LottoNumberInvalidException.lottoNumberRange();
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
}

package lotto.domain.lotto.vo;

import lotto.infrastructure.constant.ExceptionMessage;
import lotto.infrastructure.exception.CustomException;

public record LottoNumber(int value) {
    public static final int MAX = 45;
    public static final int MIN = 1;

    public static LottoNumber of(final int number) {
        validate(number);
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof LottoNumber) {
            return ((LottoNumber) object).value == value;
        }
        if (object instanceof Integer) {
            return (Integer) object == value;
        }
        return false;
    }

    private static void validate(final int number) {
        if (number > MAX || number < MIN) {
            throw new CustomException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }
}

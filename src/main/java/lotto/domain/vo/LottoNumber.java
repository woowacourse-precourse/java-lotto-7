package lotto.domain.vo;

import lotto.exception.ErrorMessage;

public class LottoNumber {
    private static final Integer MIN_LOTTO_NUMBER = 1;
    private static final Integer MAX_LOTTO_NUMBER = 45;

    private final Integer number;

    private LottoNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        validate(number);
        return new LottoNumber(number);
    }

    public Integer getValue() {
        return number;
    }

    private static void validate(Integer value) {
        validateLottoNumberRange(value);
    }

    private static void validateLottoNumberRange(Integer value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}

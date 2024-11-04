package lotto.domain.vo;

import lotto.domain.constants.LottoConstants;
import lotto.exception.ErrorMessage;

public class LottoNumber {
    private final Integer number;

    private LottoNumber(Integer number) {
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
        if (value < LottoConstants.MIN_LOTTO_NUMBER || value > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}

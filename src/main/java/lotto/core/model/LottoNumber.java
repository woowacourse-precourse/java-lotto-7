package lotto.core.model;

import lotto.core.constants.Error;
import lotto.core.dto.LottoNumberDto;

public record LottoNumber(Integer value) {

    public LottoNumber {
        if (!LottoNumber.isNumber(value)) {
            throw new IllegalArgumentException(Error.LottoNumber.INVALID_NUMBER_RANGE);
        }
    }

    public static LottoNumber dtoOf(LottoNumberDto dto) {
        return new LottoNumber(dto.value());
    }

    public static boolean isNumber(Integer value) {
        return value != null &&
                value >= LottoRule.LOTTO_NUM_MIN_VALUE &&
                value <= LottoRule.LOTTO_NUM_MAX_VALUE;
    }
}

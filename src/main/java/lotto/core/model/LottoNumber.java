package lotto.core.model;

import lotto.core.constants.Error;
import lotto.core.dto.LottoNumberDto;

public record LottoNumber(Integer value) {

    private static final Integer MIN_VALUE = 1;

    private static final Integer MAX_VALUE = 45;

    public LottoNumber {
        if (!LottoNumber.isNumber(value)) {
            throw new IllegalArgumentException(Error.LottoNumber.INVALID_NUMBER_RANGE);
        }
    }

    public static LottoNumber dtoOf(LottoNumberDto dto) {
        return new LottoNumber(dto.value());
    }

    public static boolean isNumber(Integer value) {
        return value != null && value >= MIN_VALUE && value <= MAX_VALUE;
    }
}

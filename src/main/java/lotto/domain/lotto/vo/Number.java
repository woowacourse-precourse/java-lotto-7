package lotto.domain.lotto.vo;

import static lotto.domain.lotto.constants.LottoNumber.*;
import static lotto.infrastructure.exception.ErrorCode.*;

public record Number(Integer number) {

    public Number {
        validate(number);
    }

    private void validate(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER.getCriteria() || number > MAXIMUM_LOTTO_NUMBER.getCriteria()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}

package lotto.domain.lotto.vo;

import static lotto.domain.lotto.Lotto.*;
import static lotto.infrastructure.exception.ErrorCode.*;

public record Number(Integer number) {

    public Number {
        validate(number);
    }

    private void validate(Integer number) {
        if (number < LOTTO_NUMBER_MINIMUM_CRITERION || number > LOTTO_NUMBER_MAXIMUM_CRITERION) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}

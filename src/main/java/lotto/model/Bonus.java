package lotto.model;

import static lotto.common.constants.ExceptionMessages.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.common.constants.LottoConstants.LOTTO_RANGE_END;
import static lotto.common.constants.LottoConstants.LOTTO_RANGE_START;

public class Bonus {
    private final Integer number;

    public Bonus(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < LOTTO_RANGE_START || number > LOTTO_RANGE_END) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public Integer getNumber() {
        return number;
    }
}

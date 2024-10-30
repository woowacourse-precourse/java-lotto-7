package lotto.model;

import static lotto.constants.LottoConfig.NUMBER_RANGE_MAXIMUM;
import static lotto.constants.LottoConfig.NUMBER_RANGE_MINIMUM;

import lotto.constants.ErrorMessage;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_OUT_OF_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isOutOfRange(int number) {
        return number < NUMBER_RANGE_MINIMUM || number > NUMBER_RANGE_MAXIMUM;
    }

    public int getNumber() {
        return number;
    }
}

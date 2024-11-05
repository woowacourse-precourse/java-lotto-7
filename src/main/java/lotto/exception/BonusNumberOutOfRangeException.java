package lotto.exception;

import static lotto.constants.ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE;

public class BonusNumberOutOfRangeException extends IllegalArgumentException {
    public BonusNumberOutOfRangeException() {
        super(BONUS_NUMBER_OUT_OF_RANGE);
    }
}

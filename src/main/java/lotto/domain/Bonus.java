package lotto.domain;

import lotto.exception.BonusException;
import lotto.message.ExceptionMessage;

public class Bonus {

    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;

    private final Integer number;

    public Bonus(Integer number) {
        validateRange(number);
        this.number = number;
    }

    private boolean IsNumberRangeIncorrect(Integer number) {
        return number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE;
    }

    private void validateRange(Integer number) {
        if (IsNumberRangeIncorrect(number)) {
            throw new BonusException(ExceptionMessage.INPUT_BONUS_RANGE_EXCEPTION);
        }
    }

    public Integer getNumber() {
        return number;
    }
}

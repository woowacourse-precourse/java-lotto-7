package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (!(LottoConstant.MIN_NUMBER.getValue() <= value && value <= LottoConstant.MAX_NUMBER.getValue())) {
            ExceptionMessage message = ExceptionMessage.INVALID_RANGE;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public boolean isSame(int number) {
        return number == value;
    }

    public int getValue() {
        return value;
    }
}

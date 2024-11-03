package lotto.domain;

import java.util.List;
import lotto.message.ExceptionMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumberRange(int number) {
        if (number < LottoOption.MIN_LOTTO_NUMBER || LottoOption.MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}

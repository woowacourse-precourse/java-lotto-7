package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.GameException;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < LottoOption.MIN_NUMBER_OF_RANGE.value() || number > LottoOption.MAX_NUMBER_OF_RANGE.value()) {
            throw new GameException(ErrorMessage.OUT_OF_RANGE);
        }
    }

}

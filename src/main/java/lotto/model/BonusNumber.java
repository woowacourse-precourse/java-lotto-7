package lotto.model;

import lotto.exception.GameException;

import static lotto.exception.ErrorMessage.OUT_OF_RANGE;
import static lotto.model.LottoOption.MAX_NUMBER_OF_RANGE;
import static lotto.model.LottoOption.MIN_NUMBER_OF_RANGE;

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
        if (number < MIN_NUMBER_OF_RANGE.value() || number > MAX_NUMBER_OF_RANGE.value()) {
            throw new GameException(OUT_OF_RANGE);
        }
    }

}

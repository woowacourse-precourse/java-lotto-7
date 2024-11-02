package lotto.model;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

import lotto.exception.LottoNumberOutOfRangeException;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    private void validateLottoNumberRange(Integer number) {
        if (!isLottoNumberRange(number)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public Integer getNumber() {
        return number;
    }
}

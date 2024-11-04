package lotto.model;

import lotto.constant.ErrorMessage;

import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    private void validateLottoNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}

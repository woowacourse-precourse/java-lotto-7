package lotto.validation;

import static lotto.constants.LottoConfig.AMOUNT_UNIT;
import static lotto.constants.LottoConfig.ZERO;

import static lotto.constants.ExceptionMessage.INVALID_AMOUNT_UNIT;

public class InputMoneyValidator {
    public int validate(int value) {
        isNotPositive(value);
        idValidateAmountUnit(value);
        return value;
    }

    private void isNotPositive(int money) {
        if (money <= ZERO.getValue()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }

    private void idValidateAmountUnit(int money) {
        if (money % AMOUNT_UNIT.getValue() != ZERO.getValue()) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.format());
        }
    }
}
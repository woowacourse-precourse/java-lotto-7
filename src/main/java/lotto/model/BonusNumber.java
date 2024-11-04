package lotto.model;

import lotto.model.constant.ErrorMessage;

public class BonusNumber {
    private final int number;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 45;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER_VALUE || number > MAX_NUMBER_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public int getNumber() {
        return this.number;
    }
}

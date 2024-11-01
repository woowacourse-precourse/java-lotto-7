package lotto.model;

import lotto.common.ErrorMessage;

public class BonusNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private final Integer number;

    public BonusNumber(Integer number) {
        validateBonusNumber(number);
        this.number = number;
    }

    public void validateBonusNumber(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public Integer getNumber() {
        return number;
    }
}

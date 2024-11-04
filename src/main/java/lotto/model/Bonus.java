package lotto.model;

import static lotto.common.constants.ExceptionMessages.ERROR_LOTTO_NUMBER_RANGE;

public class Bonus {
    private final Integer number;

    public Bonus(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public Integer getNumber() {
        return number;
    }
}

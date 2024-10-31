package lotto.domain;

import lotto.common.validator.NumberValidator;

public class Number {
    private final int number;

    public Number(String number) {
        NumberValidator.validate(number);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }
}

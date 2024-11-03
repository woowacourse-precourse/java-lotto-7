package lotto.model.win;

import lotto.util.Validator;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        Validator.checkBonusNumberRange(number);
    }

    public int get() {
        return number;
    }
}

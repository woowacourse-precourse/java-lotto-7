package lotto.model.win;

import lotto.util.Validator;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validateBonusNumber(number);
        this.number = number;
    }

    private void validateBonusNumber(int number) {
        Validator.checkBonusNumberRange(number);
    }

    public int get() {
        return number;
    }
}

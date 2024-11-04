package lotto.domain.winning;

import static lotto.constant.Error.RANGE_BONUS_NUMBER;

import lotto.domain.Lotto;
import lotto.validation.NumbersValidation;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public boolean hits(Lotto lotto) {
        return lotto.hasNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        NumbersValidation.validateRange(number, RANGE_BONUS_NUMBER);
    }
}

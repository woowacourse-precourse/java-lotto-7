package lotto.wrapper;

import lotto.util.validator.LottoValidator;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        LottoValidator.validateRange(number);
        this.number = number;
    }

    public static BonusNumber of(int number) {
        return new BonusNumber(number);
    }

    public int getNumber() {
        return number;
    }

}

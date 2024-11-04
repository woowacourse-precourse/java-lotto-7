package lotto.domain.bonus;

import lotto.common.LottoValidateUtil;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        LottoValidateUtil.validateNumberRange(number);
    }
}

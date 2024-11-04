package lotto.domain;

import lotto.validation.LottoValidator;

public class BonusLotto {
    private final int number;

    public BonusLotto(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        LottoValidator.checkNumberInRange(number);
    }

    //getter
    public int getNumber() {
        return number;
    }
}

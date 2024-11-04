package lotto;

import lotto.util.validator.LottoValidator;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        LottoValidator.validateNumber(number);
    }

    public Integer getNumber() {
        return number;
    }

}

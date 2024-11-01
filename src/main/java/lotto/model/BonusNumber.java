package lotto.model;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(Lotto lotto, Integer number) {
        validateDuplicated(lotto, number);
        this.number = number;
    }

    public Integer getBonusNumber() {
        return number;
    }
}

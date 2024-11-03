package lotto.model;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;

public class LottoBonusNumber {

    private final Integer number;

    public LottoBonusNumber(Lotto lotto, Integer number) {
        validateDuplicated(lotto, number);
        this.number = number;
    }

    public Integer getBonusNumber() {
        return number;
    }
}

package lotto.model;

import lotto.validation.LottoBonusNumberValidator;
import lotto.validation.Validator;

public class LottoBonusNumber {

    private final int bonusNumber;
    private final Validator<Integer> validator = new LottoBonusNumberValidator();

    public LottoBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validator.validate(bonusNumber);
    }




}

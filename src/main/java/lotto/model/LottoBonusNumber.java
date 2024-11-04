package lotto.model;

import lotto.validation.LottoBonusNumberValidator;
import lotto.validation.Validator;

public class LottoBonusNumber {

    private static LottoBonusNumber instance;
    private final int bonusNumber;
    private final Validator<Integer> validator = new LottoBonusNumberValidator();

    private LottoBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validator.validate(bonusNumber);
    }

    public static LottoBonusNumber getInstance(int bonusNumber) {
        if(instance==null){
            instance = new LottoBonusNumber(bonusNumber);
        }
        return instance;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }




}

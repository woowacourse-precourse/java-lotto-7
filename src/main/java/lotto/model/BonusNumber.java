package lotto.model;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.DelimiterPattern.*;
import static lotto.constant.Constants.*;


public class BonusNumber {
    private final Integer bonus;

    public BonusNumber(String bonus){
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validate(String bonus){
        if(bonus.isEmpty()) throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        if(!bonus.matches(NUMBER_VALIDATION_REGEX.getPattern())) throw new IllegalArgumentException(NOT_RANGE_NUMBER.getMessage());
        if(Integer.parseInt(bonus)< LOTTO_NUMBER_START_RANGE.getConstant() || Integer.parseInt(bonus)>LOTTO_NUMBER_END_RANGE.getConstant()) throw new IllegalArgumentException(NOT_RANGE_NUMBER.getMessage());
    }

    public Integer getBonus(){return this.bonus;}

}

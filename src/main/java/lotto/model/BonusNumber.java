package lotto.model;

import lotto.constant.Constants;
import lotto.constant.DelimiterPattern;
import lotto.constant.ErrorMessage;

public class BonusNumber {
    private final Integer bonus;

    public BonusNumber(String bonus){
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validate(String bonus){
        if(bonus.isEmpty()) throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        if(!bonus.matches(DelimiterPattern.NUMBER_VALIDATION_REGEX.getPattern())) throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
        if(Integer.parseInt(bonus)< Constants.LOTTO_NUMBER_START_RANGE.getConstant() || Integer.parseInt(bonus)>Constants.LOTTO_NUMBER_END_RANGE.getConstant()) throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
    }

    public Integer getBonus(){return this.bonus;}

}

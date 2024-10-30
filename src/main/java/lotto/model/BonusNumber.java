package lotto.model;

import lotto.constant.ErrorMessage;

public class BonusNumber {
    private Integer bonus;

    public BonusNumber(String bonus){
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validate(String bonus){
        if(bonus.isEmpty()) throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        if(!bonus.matches("^-?\\d+$")) throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
        if(Integer.parseInt(bonus)<1 || Integer.parseInt(bonus)>45) throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
    }

    public Integer getBonus(){return this.bonus;}

}

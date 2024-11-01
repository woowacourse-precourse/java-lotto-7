package lotto.model;

import lotto.validation.GlobalValidation;

import static lotto.message.ErrorMessage.*;
public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber){
        if(GlobalValidation.isLottoNumberOutOfRange(bonusNumber)){
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }


}

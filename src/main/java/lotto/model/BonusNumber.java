package lotto.model;

import static lotto.common.Constant.MAX_LOTTO_NUMBER;
import static lotto.common.Constant.MIN_LOTTO_NUMBER;
import static lotto.common.ErrorMessage.NUMBER_OUT_OF_RANGE;

public class BonusNumber {
    private final int bonusNumber;
    public BonusNumber(int bonusNumber){
        isNumberBetween1And45(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void isNumberBetween1And45(int bonusNumber){
        if(bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.format());
        }
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}

package lotto.model;

import static lotto.utils.Constants.MAX_LOTTO_NUMBER;
import static lotto.utils.Constants.MIN_LOTTO_NUMBER;


public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber){
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber(){
        return bonusNumber;
    }
    private void validate(Integer bonusNumber) {
        checkBonusNumberRange(bonusNumber);
    }

    private void checkBonusNumberRange(Integer bonusNumber){
        if (bonusNumber <= MIN_LOTTO_NUMBER || bonusNumber >= MAX_LOTTO_NUMBER)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}

package lotto.model.domain;

import lotto.constant.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        bonusNumberRangeValidator(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberRangeValidator(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_VALIDATOR.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.Limit;
import lotto.util.Message;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber){
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber){
        if(bonusNumber < Limit.MIN_LOTTO_NUMBER.getValue() || bonusNumber > Limit.MAX_LOTTO_NUMBER.getValue()){
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.BONUS_NUMBER_RANGE.getError());
        }
    }
}

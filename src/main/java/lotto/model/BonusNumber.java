package lotto.model;

import lotto.util.common.ErrorMessage;
import lotto.util.common.Limit;
import lotto.util.common.Message;

public record BonusNumber(int bonusNumber) {
    public BonusNumber {
        validate(bonusNumber);
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < Limit.MIN_LOTTO_NUMBER.getValue() || bonusNumber > Limit.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.BONUS_NUMBER_RANGE.getError());
        }
    }
}

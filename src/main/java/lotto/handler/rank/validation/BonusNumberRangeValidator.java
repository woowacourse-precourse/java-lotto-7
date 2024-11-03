package lotto.handler.rank.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class BonusNumberRangeValidator implements WinningNumberValidator {
    @Override
    public void validate(HandlerToken handlerToken) {
        int bonusNumber = getBonusNumberToInteger(handlerToken);
        if (!isValidRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private boolean isValidRange(int bonusNumber) {
        return (bonusNumber >= 1) && (bonusNumber <= 45);
    }
}
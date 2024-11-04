package lotto.handler.rank.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class BonusNumberFormatValidator implements WinningNumberValidator {
    private static final String VALID_BONUS_NUMBER_FORMAT = "^[0-9]+";

    @Override
    public void validate(HandlerToken handlerToken) {
        String bonusNumber = getBonusNumberToString(handlerToken);
        if (!isValidFormat(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    private boolean isValidFormat(String bonusNumber) {
        return bonusNumber.matches(VALID_BONUS_NUMBER_FORMAT);
    }
}

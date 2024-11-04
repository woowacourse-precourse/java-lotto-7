package lotto.handler.rank.validation;

import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class WinningNumberFormatValidator implements WinningNumberValidator {
    private static final String VALID_REGULAR_EXPRESSION = "^[0-9]+(,[0-9]+)*$";

    @Override
    public void validate(HandlerToken handlerToken) {
        String winningNumbers = getWinningNumbersToString(handlerToken);
        if (!isValidFormat(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    private boolean isValidFormat(String winningNumbers) {
        return winningNumbers.matches(VALID_REGULAR_EXPRESSION);
    }
}

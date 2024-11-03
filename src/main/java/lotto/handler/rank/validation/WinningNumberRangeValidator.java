package lotto.handler.rank.validation;

import java.util.List;
import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class WinningNumberRangeValidator implements WinningNumberValidator {
    @Override
    public void validate(HandlerToken handlerToken) {
        List<Integer> winningNumbers = getWinningNumbersToList(handlerToken);
        for (int winningNumber : winningNumbers) {
            checkValid(winningNumber);
        }
    }

    private void checkValid(int winningNumber) {
        if (!isValidRange(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private boolean isValidRange(int winningNumber) {
        return (winningNumber >= 1) && (winningNumber <= 45);
    }
}

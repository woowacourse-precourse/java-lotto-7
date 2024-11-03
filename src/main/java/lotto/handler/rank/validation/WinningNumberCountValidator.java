package lotto.handler.rank.validation;

import java.util.List;
import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class WinningNumberCountValidator implements WinningNumberValidator {
    @Override
    public void validate(HandlerToken handlerToken) {
        List<Integer> winningNumbers = getWinningNumbersToList(handlerToken);
        if (!isValidCount(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_COUNT_ERROR.getErrorMessage());
        }
    }

    private boolean isValidCount(List<Integer> winningNumbers) {
        return winningNumbers.size() == 6;
    }
}

package lotto.handler.rank.validation;

import java.util.List;
import lotto.handler.ErrorMessage;
import lotto.handler.token.HandlerToken;

public class AllNumberDuplicateValidator implements WinningNumberValidator {

    @Override
    public void validate(HandlerToken handlerToken) {
        int bonusNumber = getBonusNumberToInteger(handlerToken);
        List<Integer> winningNumbers = getWinningNumbersToList(handlerToken);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER_ERROR.getErrorMessage());
        }

        if (hasDuplicateNumber(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUMBER_ERROR.getErrorMessage());
        }
    }

    private boolean hasDuplicateNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream().distinct().count() != winningNumbers.size();
    }
}

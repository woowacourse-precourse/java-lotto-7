package lotto.io;

import lotto.exception.EmptyWinningNumberInputException;
import lotto.exception.IllegalNumberFormatException;

public class InputValidator {

    public Long validateBuyAmount(String buyAmount) {
        try {
            return Long.parseLong(buyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalNumberFormatException();
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.trim().isEmpty()) {
            throw new EmptyWinningNumberInputException();
        }
    }

    public int validateBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalNumberFormatException();
        }
    }
}

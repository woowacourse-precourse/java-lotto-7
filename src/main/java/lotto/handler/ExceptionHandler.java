package lotto.handler;

import lotto.message.error.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExceptionHandler {

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
            }
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
    }

}

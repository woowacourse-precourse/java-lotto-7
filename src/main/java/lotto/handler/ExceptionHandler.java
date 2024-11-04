package lotto.handler;

import lotto.message.error.ErrorMessage;

public class ExceptionHandler {

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        for (String number : winningNumbers.split(",")) {
            int num = Integer.parseInt(number);
            if (num < 1 || num > 45) {
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

package lotto.util;

import static lotto.constant.ErrorMessage.NOT_INPUT_BLANK;
import static lotto.constant.ErrorMessage.NOT_NUMBER_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.TOO_BIG_PURCHASE_AMOUNT;
import static lotto.constant.ExtraText.WINNING_NUMBER_SEPARATOR;

public class UserInputValidator {
    private static final int PURCHASE_AMOUNT_LENGTH_LIMIT = 10;

    public void isValidPurchaseAmount(String purchaseAmount) {
        isUserInputBlank(purchaseAmount);
        isPurchaseAmountNumber(purchaseAmount);
        isPurchaseAmountTooBing(purchaseAmount);
    }

    public void isValidWinningNumbers(String winningNumbers) {
        isUserInputBlank(winningNumbers);
        isWinningNumberNumber(winningNumbers.split(WINNING_NUMBER_SEPARATOR.getText()));
    }

    public void isValidBonusNumber(String bonusNumber) {
        isUserInputBlank(bonusNumber);
        isBonusNumberNumber(bonusNumber);
    }

    private void isUserInputBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(NOT_INPUT_BLANK.getMessage());
        }
    }

    private void isPurchaseAmountNumber(String purchaseAmount) {
        if (!purchaseAmount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void isPurchaseAmountTooBing(String purchaseAmount) {
        if (purchaseAmount.length() > PURCHASE_AMOUNT_LENGTH_LIMIT) {
            throw new IllegalArgumentException(TOO_BIG_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void isWinningNumberNumber(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            //System.out.println(currentNumber);
            if (!winningNumber.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(NOT_NUMBER_PURCHASE_AMOUNT.getMessage());
            }
        }
    }

    private void isBonusNumberNumber(String bonusNumber) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_BONUS_NUMBER.getMessage());
        }
    }
}

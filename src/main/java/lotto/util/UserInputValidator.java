package lotto.util;

import static lotto.constant.ErrorMessage.LESS_THAN_THOUSAND_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_WINNING_NUMBER;
import static lotto.constant.ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT;
import static lotto.constant.ErrorMessage.TOO_BIG_PURCHASE_AMOUNT;

public class UserInputValidator {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int PURCHASE_AMOUNT_LENGTH_LIMIT = 10;
    private static final int PURCHASE_AMOUNT_REMAIN = 0;
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    public void isValidPurchaseAmount(String purchaseAmount) {
        isPurchaseAmountNumber(purchaseAmount);
        isPurchaseAmountTooBing(purchaseAmount);
        isPurchaseAmountLessThanThousand(purchaseAmount);
        isPurchaseAmountMultipleOfThousand(purchaseAmount);
    }

    public void isValidWinningNumbers(String[] winningNumbers) {
        isWinningNumbersSizeSix(winningNumbers);
        isWinningNumberNumber(winningNumbers);
        isWinningNumberInRange(winningNumbers);
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

    private void isPurchaseAmountLessThanThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < PURCHASE_AMOUNT_UNIT) {
            throw new IllegalArgumentException(LESS_THAN_THOUSAND_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void isPurchaseAmountMultipleOfThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % PURCHASE_AMOUNT_UNIT != PURCHASE_AMOUNT_REMAIN) {
            throw new IllegalArgumentException(NOT_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }

    private void isWinningNumberNumber(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (!winningNumber.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(NOT_NUMBER_PURCHASE_AMOUNT.getMessage());
            }
        }
    }

    private void isWinningNumbersSizeSix(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void isWinningNumberInRange(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (Integer.parseInt(winningNumber) < WINNING_NUMBER_MIN
                    || Integer.parseInt(winningNumber) > WINNING_NUMBER_MAX) {
                throw new IllegalArgumentException(NOT_NUMBER_RANGE_WINNING_NUMBER.getMessage());
            }
        }
    }
}

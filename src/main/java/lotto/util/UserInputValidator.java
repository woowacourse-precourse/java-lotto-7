package lotto.util;

import static lotto.constant.ErrorMessage.LESS_THAN_THOUSAND_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_INPUT_BLANK;
import static lotto.constant.ErrorMessage.NOT_NUMBER_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_WINNING_NUMBER;
import static lotto.constant.ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT;
import static lotto.constant.ErrorMessage.TOO_BIG_PURCHASE_AMOUNT;
import static lotto.constant.ExtraText.WINNING_NUMBER_SEPARATOR;

public class UserInputValidator {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int PURCHASE_AMOUNT_LENGTH_LIMIT = 10;
    private static final int PURCHASE_AMOUNT_REMAIN = 0;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final String SPACE = " ";
    private static final String BLANK = "";

    public void isValidPurchaseAmount(String purchaseAmount) {
        isUserInputBlank(purchaseAmount);
        isPurchaseAmountNumber(purchaseAmount);
        isPurchaseAmountTooBing(purchaseAmount);
        isPurchaseAmountLessThanThousand(purchaseAmount);
        isPurchaseAmountMultipleOfThousand(purchaseAmount);
    }

    public void isValidWinningNumbers(String winningNumbers) {
        isUserInputBlank(winningNumbers);
        isWinningNumberNumber(winningNumbers.split(WINNING_NUMBER_SEPARATOR.getText()));
        isWinningNumberInRange(winningNumbers.split(WINNING_NUMBER_SEPARATOR.getText()));
    }

    public void isValidBonusNumber(String bonusNumber) {
        isUserInputBlank(bonusNumber);
        isBonusNumberNumber(bonusNumber);
        isBonusNumberRange(bonusNumber);
    }

    private void isUserInputBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(NOT_INPUT_BLANK.getMessage());
        }
    }

    private void isPurchaseAmountNumber(String purchaseAmount) {
        String blankRemoved = purchaseAmount.replaceAll(SPACE, BLANK);
        if (!blankRemoved.chars().allMatch(Character::isDigit)) {
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
            String currentNumber = winningNumber.replaceAll(SPACE, BLANK);
            //System.out.println(currentNumber);
            if (!currentNumber.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException(NOT_NUMBER_PURCHASE_AMOUNT.getMessage());
            }
        }
    }

    private void isWinningNumberInRange(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            String currentNumber = winningNumber.replaceAll(SPACE, BLANK);
            if (Integer.parseInt(currentNumber) < LOTTO_NUMBER_MIN
                    || Integer.parseInt(currentNumber) > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(NOT_NUMBER_RANGE_WINNING_NUMBER.getMessage());
            }
        }
    }

    private void isBonusNumberNumber(String bonusNumber) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_BONUS_NUMBER.getMessage());
        }
    }

    private void isBonusNumberRange(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) < LOTTO_NUMBER_MIN || Integer.parseInt(bonusNumber) > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(NOT_NUMBER_RANGE_BONUS_NUMBER.getMessage());
        }
    }
}

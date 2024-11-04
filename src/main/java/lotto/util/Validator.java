package lotto.util;

import lotto.message.ErrorMessage;
import lotto.model.Lotto;

public class Validator {
    public int validatePurchasePrice(String purchasePriceInput) {
        try{
            int purchasePrice = Integer.parseInt(purchasePriceInput);
            validatePurchasePriceMultipleOfThousand(purchasePrice);

            return purchasePrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    public void validatePurchasePriceMultipleOfThousand(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    public int validateNumber(String numberInput) {
        try{
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    public void validateWinningNumber(String[] winningNumbersInput) {
        if (winningNumbersInput.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    public int validateBonusNumber(String bonusNumberInput, Lotto winningNumbersLotto) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            validateBonusNumberInRange(bonusNumber);
            validateBonusNumberDuplicate(bonusNumber, winningNumbersLotto);

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public void validateBonusNumberDuplicate(int bonusNumber, Lotto winningNumbersLotto) {
        if (winningNumbersLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}

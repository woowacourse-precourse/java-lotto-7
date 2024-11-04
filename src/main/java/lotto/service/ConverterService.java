package lotto.service;

import lotto.constants.ConstraintConstants;
import lotto.constants.ErrorViewConstants;

import static lotto.constants.ErrorViewConstants.*;
import static lotto.service.ValidatorService.validatePurchaseAmount;

public class ConverterService {
    public static int convertPurchasePrice(String enteredPurchasePrice) {
        try {
            int purchasePrice = Integer.parseInt(enteredPurchasePrice);
            if (validatePurchaseAmount(purchasePrice)) {
                return purchasePrice / ConstraintConstants.PURCHASE_UNIT;
            }
            throw new IllegalArgumentException(INVALID_INPUT_CONSTRAINT);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }

    public static String[] splitWinningNumber(String enteredWinningNumber) {
        String[] splitWinningNumber = enteredWinningNumber.split(",");
        if (splitWinningNumber.length != ConstraintConstants.WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
        return splitWinningNumber;
    }

    public static int[] convertWinningNumber(String[] enteredWinningNumber) {
        int[] result = new int[enteredWinningNumber.length];
        for (int i = 0; i < enteredWinningNumber.length; i++) {
            result[i] = Integer.parseInt(enteredWinningNumber[i]);
            if (!ValidatorService.isValidNumber(result[i])) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
            }
        }
        return result;
    }

    public static int convertBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBERS);
        }
    }
}

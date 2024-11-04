package lotto.service;

import lotto.constants.ConstraintConstants;
import lotto.constants.ErrorViewConstants;

import static lotto.service.ValidatorService.validatePurchaseAmount;

public class ConverterService {
    public static int convertPurchasePrice(String enteredPurchasePrice) {
        try {
            int purchasePrice = Integer.parseInt(enteredPurchasePrice);
            if (validatePurchaseAmount(purchasePrice)) {
                return purchasePrice / ConstraintConstants.PURCHASE_UNIT;
            }
            throw new IllegalArgumentException(ErrorViewConstants.INVALID_INPUT_CONSTRAINT);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorViewConstants.INVALID_WINNING_NUMBERS);
        }
    }
    public static int[] stringArrayToIntegerArray(String[] inputs) {
        int[] result = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            result[i] = Integer.parseInt(inputs[i]);
        }
        return result;
    }
}

package validator;

import common.ErrorMessage;

public class InputValidator {
    public static void validataPurchaseAmount(String purchaseAmount) {
        inputEmptyCheck(purchaseAmount);
        inputNotInteger(purchaseAmount);
        inputNegative(purchaseAmount);
        inputZero(purchaseAmount);
        inputUnpayableValue(purchaseAmount);
    }

    private static void inputEmptyCheck(String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NONE_INPUT.getMessage());
        }
    }

    private static void inputNotInteger(String purchaseAmount) {
        try {
            int result = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getMessage());
        }
    }

    private static void inputNegative(String purchaseAmount) {
        int result = Integer.parseInt(purchaseAmount);
        if (result < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALUD_VALUE_NEGATIVE.getMessage());
        }
    }

    private static void inputZero(String purchaseAmount) {
        int result = Integer.parseInt(purchaseAmount);
        if (result == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALUD_VALUE_ZERO.getMessage());
        }
    }

    private static void inputUnpayableValue(String purchaseAmount) {
        int result = Integer.parseInt(purchaseAmount);
        if (result % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE.getMessage());
        }
    }
}

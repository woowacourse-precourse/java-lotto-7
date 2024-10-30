package lotto.utils;

public class InputValidator {

    public void validatePurchaseAmount(String userInput) {
        validateEmpty(userInput);

        int purchaseAmount = validateNumber(userInput);
        validateDivisibleByThousand(purchaseAmount);
    }

    private void validateEmpty(String userInput) {
        if (userInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE.toString());
        }
    }

    private int validateNumber(String userInput) {
        if (userInput.matches(Constant.INTEGER_REGEX)) {
            return Integer.parseInt(userInput);
        }

        throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
    }

    private void validateDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount < Constant.MIN_PURCHASE_AMOUNT || (purchaseAmount % Constant.MIN_PURCHASE_AMOUNT != 0)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
        }
    }
}

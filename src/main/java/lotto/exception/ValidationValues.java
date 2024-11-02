package lotto.exception;

public class ValidationValues {

    public static int purchaseAmount(String inputPurchaseAmount) {
        if(inputPurchaseAmount == null || inputPurchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_BLANK);
        }

        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            if(purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_VALUE);
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_NUMERIC_VALUE);
        }
    }

}

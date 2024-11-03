package lotto;

import static lotto.ErrorCode.INVALID_NUMBER_FORMAT;

public class InputValidator {

    public void validateAmount(String purchaseAmount) {
        validateIsNumber(purchaseAmount);
    }

    private void validateIsNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}

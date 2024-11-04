package lotto.validation;

public class Validation {
    public static void validatedPurchaseAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ValidationType.EMPTY_AMOUNT.validationMsg());
        }
    }
}

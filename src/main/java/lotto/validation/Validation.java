package lotto.validation;

public class Validation {
    public static void validatedPurchaseAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ValidationType.EMPTY_AMOUNT.validationMsg());
        }
    }
    public static void validatedThousandUnitAmount(String input) {
        try {
            int inputResult = Integer.parseInt(input);
            if (inputResult < 1000) {
                throw new IllegalArgumentException(ValidationType.NEGATIVE_AMOUNT.validationMsg());
            }
            if (!(inputResult % 1000 == 0)) {
                throw new IllegalArgumentException(ValidationType.INVALID_UNIT.validationMsg());
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationType.NOT_NUMERIC.validationMsg());
        }
    }
}

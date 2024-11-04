package lotto.global;


public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {}

    public static Validator getInstance() {
        return instance;
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateNotEmpty(purchaseAmount);
        validateInteger(purchaseAmount);
        validatePositiveInteger(purchaseAmount);
        validateMultipleOfThousand(purchaseAmount);
    }


    private void validateNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT.getMessage());
        }
    }

    private void validatePositiveInteger(String input) {
        int intInput = Integer.parseInt(input);
        if(intInput <= 0){
            throw new IllegalArgumentException(NOT_POSITIVE_INPUT.getMessage());
        }
    }

    private void validateMultipleOfThousand(String purchaseAmount) {
        int parsedAmount = Integer.parseInt(purchaseAmount);
        if (parsedAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}

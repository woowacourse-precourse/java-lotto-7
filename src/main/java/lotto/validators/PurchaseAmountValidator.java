package lotto.validators;

public class PurchaseAmountValidator implements NumberInputValidator {
    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 100000;

    @Override
    public void validate(String input) {
        checkInputType(input);
        checkDivisibility(input);
        checkValueRange(input);
    }

    private void checkDivisibility(String input) {
        int amount = Integer.parseInt(input);
        if (amount % MIN_VALUE != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_DIVISIBLE.getMessage());
        }
    }

    private void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_AMOUNT_NOT_WITHIN_RANGE.getMessage());
        }
    }
}

package lotto.util;

public class PurchaseAmountValidator implements Validator {

    private static final int MINIMUM_AMOUNT = 1000;

    @Override
    public void validate(String input) {
        int purchaseAmount = isNumber(input);
        hasMinimum(purchaseAmount);
        isDivisibleByMinimumAmount(purchaseAmount);
    }

    private void isDivisibleByMinimumAmount(int purchaseAmount) {
        if (!(purchaseAmount % MINIMUM_AMOUNT == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private void hasMinimum(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}

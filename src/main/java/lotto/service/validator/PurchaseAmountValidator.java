package lotto.service.validator;

import lotto.util.ErrorMessage;

public class PurchaseAmountValidator {
    public static boolean validateBlank(String purchaseAmount) {
        try {
            if (purchaseAmount.isBlank()) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_EMPTY_PURCHASE_AMOUNT);
            return false;
        }
    }
    public static boolean validateDivisibleBy1000(String purchaseAmount) {
        try {
            int parsedAmount = Integer.parseInt(purchaseAmount);
            if (parsedAmount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (NumberFormatException err) {
            System.out.println(ErrorMessage.ERROR_NON_INTEGER_PURCHASE_AMOUNT);
            return false;
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.ERROR_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000);
            return false;
        }
    }
}

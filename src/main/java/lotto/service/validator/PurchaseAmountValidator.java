package lotto.service.validator;

import lotto.controller.PurchaseAmountController;
import lotto.util.ErrorMessage;

public class PurchaseAmountValidator {
    public static void validateBlank(String purchaseAmount) {
        try {
            if (purchaseAmount.isBlank()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.EMPTY_PURCHASE_AMOUNT_STRING_ERROR);
            PurchaseAmountController.restart();
        }
    }
    public static void validateDivisibleBy1000(String purchaseAmount) {
        try {
            int parsedAmount = Integer.parseInt(purchaseAmount);
            if (parsedAmount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException err) {
            System.out.println(ErrorMessage.NOT_INTEGER_STRING_ERROR);
            PurchaseAmountController.restart();
        } catch (IllegalArgumentException err) {
            System.out.println(ErrorMessage.NOT_DIVISIBLE_BY_1000_ERROR);
            PurchaseAmountController.restart();
        }
    }
}

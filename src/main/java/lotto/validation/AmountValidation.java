package lotto.validation;

import lotto.exception.AmountException;

public class AmountValidation {

    public static void amountValidation(String purchaseAmount) {
        int amount = isNumber(purchaseAmount);
        isThousand(amount);
        isOverZero(amount);
    }

    public static int isNumber(String purchaseAmount) {
        int amount = 0;
        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            AmountException.exceptionAmountNumber();
        }
        return amount;
    }

    public static void isThousand(int amount) {
        if (amount % 1000 != 0) {
            AmountException.exceptionAmountThousand();
        }
    }

    public static void isOverZero(int amount) {
        if (amount <= 0) {
            AmountException.exceptionAmountZero();
        }
    }

}

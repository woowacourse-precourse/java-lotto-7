package lotto.validation;

import lotto.exception.AmountException;

public class AmountValidation {

    private static final int TICKET_COST = 1000;
    private static final int COUNT_ZERO = 0;

    public static void amountValidation(String purchaseAmount) {
        int amount = isNumber(purchaseAmount);
        isThousand(amount);
        isOverZero(amount);
    }

    public static int isNumber(String purchaseAmount) {
        int amount = COUNT_ZERO;
        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (IllegalArgumentException e) {
            AmountException.exceptionAmountNumber();
        }
        return amount;
    }

    public static void isThousand(int amount) {
        if (amount % TICKET_COST != COUNT_ZERO) {
            AmountException.exceptionAmountThousand();
        }
    }

    public static void isOverZero(int amount) {
        if (amount <= COUNT_ZERO) {
            AmountException.exceptionAmountZero();
        }
    }

}

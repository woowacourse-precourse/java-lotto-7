package lotto.validation;

public class BuyLottoValidate {
    private static final int THOUSAND_MULTI_NUMBER = 1000;
    private static final int ZERO = 0;

    public static int lottoBuyValidation(String inputAmount) {
        int count;
        int amount = amountValidation(inputAmount);
        checkNegativeNumber(amount);
        count = thousandMultiple(amount);
        return count;
    }

    public static int amountValidation(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNegativeNumber(int amount) {
        if (amount < ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public static int thousandMultiple(int amount) {
        if (amount % THOUSAND_MULTI_NUMBER != ZERO || amount == ZERO) {
            throw new IllegalArgumentException();
        }
        return amount / THOUSAND_MULTI_NUMBER;
    }
}

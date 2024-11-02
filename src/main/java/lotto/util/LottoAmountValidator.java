package lotto.util;

import static lotto.util.Constants.*;

public class LottoAmountValidator {
    private static final int LOTTO_PRICE = 1000;
    private int amount;

    public int validate(String price) {
        validateNumber(price);
        validateAmount();
        validateDivisibleAmount();
        calculateLottoCount();
        return amount;
    }

    private void validateNumber(String price) {
        try {
            amount = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_START.getMessage() + ERROR_NUMBER.getMessage());
        }
    }

    private void validateAmount() {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_START.getMessage() + ERROR_AMOUNT.getMessage());
        }
    }

    private void validateDivisibleAmount() {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_START.getMessage() + ERROR_DIVISIBLE_AMOUNT.getMessage());
        }
    }

    public void calculateLottoCount() {
        amount /= LOTTO_PRICE;
    }
}
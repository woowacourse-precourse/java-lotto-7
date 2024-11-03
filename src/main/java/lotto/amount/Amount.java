package lotto.amount;

import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Amount {

    private static final int LOTTO_PURCHASE_UNIT = 1_000;
    public static final int MAX_PURCHASE_UNIT = 100_000;

    private final int value;

    public Amount(int value) {
        validatePurchaseUnit(value);
        validateExceedMaxPurchaseAmount(value);
        this.value = value;
    }

    public int calculateLottoCount() {
        return value / LOTTO_PURCHASE_UNIT;
    }

    public int getValue() {
        return value;
    }

    private void validatePurchaseUnit(int amount) {
        if (isNotDivisibleByLottoPurchaseUnit(amount)) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_AMOUNT_EXCEPTION);
        }
    }

    private boolean isNotDivisibleByLottoPurchaseUnit(int amount) {
        return amount % LOTTO_PURCHASE_UNIT != 0;
    }

    private void validateExceedMaxPurchaseAmount(int amount) {
        if (amount > MAX_PURCHASE_UNIT) {
            throw new CustomException(ExceptionMessage.EXCEED_MAX_LOTTO_AMOUNT_EXCEPTION);
        }
    }
}

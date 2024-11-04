package lotto.model.domain;

import lotto.global.MoneyInputErrorMessage;

import static lotto.global.Constants.LOTTO_PRICE;

public class Money {
    private final long amount;

    public Money(long amount) {
        validatePositiveAmount(amount);
        validateMultipleOfThousand(amount);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    private void validatePositiveAmount(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateMultipleOfThousand(long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MoneyInputErrorMessage.NON_THOUSAND_MULTIPLE.getMessage());
        }
    }
}
package lotto.model.money;

import static lotto.exception.InvalidUnitAmountException.invalidUnitAmount;
import static lotto.exception.ShouldNotBeMinusException.minusMoney;

import java.text.DecimalFormat;

public class Money {

    public static final Money ZERO = new Money(0L);
    public static final Money LOTTO_PRICE = Money.from(1000L);
    private static final DecimalFormat wonFormatter = new DecimalFormat("###,###");

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money from(long value) {
        validateIsMinus(value);
        return new Money(value);
    }

    public long calculatePurchasedLottoCount() {
        if (hasRemainder()) {
            throw invalidUnitAmount();
        }
        return this.value / LOTTO_PRICE.value;
    }

    private boolean hasRemainder() {
        return this.value % LOTTO_PRICE.value != 0;
    }

    private static void validateIsMinus(long value) {
        if (value < 0) {
            throw minusMoney();
        }
    }

    @Override
    public String toString() {
        return wonFormatter.format(this);
    }
}

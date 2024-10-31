package lotto.model.money;

import static lotto.exception.InvalidUnitAmountException.invalidUnitAmount;
import static lotto.exception.ShouldNotBeMinusException.minusMoney;

import java.text.DecimalFormat;

public class Money {

    public static final Money ZERO = new Money(0L);
    public static final Money LOTTO_PRICE = Money.from(1000L);
    public static final Money FIRST_RANK_PRIZE = Money.from(2000000000L);
    public static final Money SECOND_RANK_PRIZE = Money.from(30000000L);
    public static final Money THIRD_RANK_PRIZE = Money.from(1500000L);
    public static final Money FOURTH_RANK_PRIZE = Money.from(50000L);
    public static final Money FIFTH_RANK_PRIZE = Money.from(5000L);
    private static final DecimalFormat wonFormatter = new DecimalFormat("###,###");

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money from(long value) {
        validateIsMinus(value);
        return new Money(value);
    }

    public int calculatePurchasedLottoCount() {
        validateRemainder();
        return (int) (this.value / LOTTO_PRICE.value);
    }

    private void validateRemainder() {
        boolean hasRemainder = this.value % LOTTO_PRICE.value != 0;
        if (hasRemainder) {
            throw invalidUnitAmount();
        }
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

package model.money;

public class Money {

    private static final Money LOTTO_PRICE = Money.from(1000L);

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    public boolean isDivisible(Money money) {
        return money.value % LOTTO_PRICE.value != 0;
    }

    public boolean isZero(Money money) {
        return money.value == 0;
    }

    public int calculateLottoCount() {
        return (int) (value / LOTTO_PRICE.value);
    }

    public long getValue() {
        return value;
    }
}

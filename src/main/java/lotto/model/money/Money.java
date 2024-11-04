package lotto.model.money;

import static lotto.exception.InvalidUnitAmountException.invalidUnitAmount;
import static lotto.exception.ShouldNotBeMinusException.minusMoney;
import static lotto.model.money.Money.Currency.WON;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class Money {

    enum Currency {
        WON("원");

        final String value;

        Currency(final String value) {
            this.value = value;
        }
    }

    private static final DecimalFormat FORMATTER = new DecimalFormat("###,###");

    public static final Money ZERO = Money.from(0L);
    public static final Money LOTTO_PRICE = Money.from(1000L);
    public static final Money FIRST_RANK_PRIZE = Money.from(2000000000L);
    public static final Money SECOND_RANK_PRIZE = Money.from(30000000L);
    public static final Money THIRD_RANK_PRIZE = Money.from(1500000L);
    public static final Money FOURTH_RANK_PRIZE = Money.from(50000L);
    public static final Money FIFTH_RANK_PRIZE = Money.from(5000L);

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money from(final long value) {
        validateIsMinus(value);
        return new Money(value);
    }

    public static Money addAll(final List<Money> monies) {
        long addedMoney = monies.stream()
                .mapToLong(money -> money.value)
                .sum();
        return Money.from(addedMoney);
    }

    public Money plus(final Money money) {
        return Money.from(this.value + money.value);
    }

    public Money multiply(final long source) {
        return Money.from(this.value * source);
    }

    public int calculatePurchasedLottoCount() {
        validateRemainder();
        return (int) (this.value / LOTTO_PRICE.value);
    }

    public boolean hasSmallChange() {
        return this.value % LOTTO_PRICE.value != 0;
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(this.value);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Money money = (Money) obj;
        return money.value == this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        String formattedMoney = FORMATTER.format(this.value);
        return String.format("%s%s", formattedMoney, WON.value);
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
}

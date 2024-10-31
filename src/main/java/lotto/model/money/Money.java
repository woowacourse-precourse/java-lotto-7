package lotto.model.money;

import static lotto.exception.InvalidUnitAmountException.invalidUnitAmount;
import static lotto.exception.ShouldNotBeMinusException.minusMoney;
import static lotto.model.money.Money.Currency.WON;
import static lotto.model.rank.RankCondition.FIFTH;
import static lotto.model.rank.RankCondition.FIRST;
import static lotto.model.rank.RankCondition.FOURTH;
import static lotto.model.rank.RankCondition.NONE;
import static lotto.model.rank.RankCondition.SECOND;
import static lotto.model.rank.RankCondition.THIRD;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.model.rank.RankCondition;

public class Money {

    enum Currency {
        WON("원");

        final String value;

        Currency(final String value) {
            this.value = value;
        }
    }

    public static final Money ZERO = new Money(0L);
    public static final Money LOTTO_PRICE = Money.from(1000L);

    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    private static final Map<RankCondition, Money> moneyTable = new EnumMap<>(Map.of(
            FIRST, Money.from(2000000000L),
            SECOND, Money.from(30000000L),
            THIRD, Money.from(1500000L),
            FOURTH, Money.from(50000L),
            FIFTH, Money.from(5000L),
            NONE, ZERO
    ));

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money from(long value) {
        validateIsMinus(value);
        return new Money(value);
    }

    public static Money findByRank(RankCondition rank) {
        return moneyTable.get(rank);
    }

    public static Money addAll(List<Money> monies) {
        long addedMoney = monies.stream()
                .mapToLong(money -> money.value)
                .sum();
        return Money.from(addedMoney);
    }

    public Money plus(Money money) {
        return Money.from(this.value + money.value);
    }

    public Money multiply(int source) {
        return Money.from(this.value * source);
    }

    public int calculatePurchasedLottoCount() {
        validateRemainder();
        return (int) (this.value / LOTTO_PRICE.value);
    }

    @Override
    public boolean equals(Object obj) {
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
        String formattedMoney = formatter.format(this.value);
        return String.format("%s%s", formattedMoney, WON.value);
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(this.value);
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

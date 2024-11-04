package lotto.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private static final String MINUS_MONEY_ERROR_MESSAGE = "돈은 음수가 불가능합니다.";
    private static final String REMAINING_BALANCE_ERROR_MESSAGE = "잔액이 발생합니다.";
    private static final int EMPTY_MONEY = 0;
    public static final Money EMPTY = new Money(EMPTY_MONEY);
    private static final int PERCENT_MULTIPLIER = 100;
    private static final BigDecimal PERCENT_UNIT = new BigDecimal(PERCENT_MULTIPLIER);
    private static final int SCALE = 3;

    private final int amount;


    public Money(int amount) {
        if(isMinusMoney(amount))
            throw new IllegalArgumentException(MINUS_MONEY_ERROR_MESSAGE);
        this.amount = amount;
    }

    public Money plus(Money money) {
        return new Money(amount + money.amount);
    }

    public int countBundle(Money bundleUnit) {
        if(hasRemainingBalance(bundleUnit))
            throw new IllegalArgumentException(REMAINING_BALANCE_ERROR_MESSAGE);
        return amount / bundleUnit.amount;
    }

    private boolean hasRemainingBalance(Money bundleUnit) {
        return bundleUnit.equals(EMPTY) || amount % bundleUnit.amount != EMPTY_MONEY;
    }

    public double rateAsPercent(Money money) {
        BigDecimal baseAmount = new BigDecimal(String.valueOf(amount));
        BigDecimal referenceAmount = new BigDecimal(String.valueOf(money.amount));

        return toPercent(
                baseAmount.divide(referenceAmount, SCALE, RoundingMode.HALF_UP)
        ).doubleValue();
    }

    private BigDecimal toPercent(BigDecimal number) {
        return number.multiply(PERCENT_UNIT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.format("%,d",amount);
    }

    private boolean isMinusMoney(int amount) {
        return amount < EMPTY_MONEY;
    }

}

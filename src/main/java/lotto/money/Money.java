package lotto.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private static final int EMPTY_MONEY = 0;
    public static final Money EMPTY = new Money(EMPTY_MONEY);
    private static final int PERCENT_MULTIPLIER = 100;
    private static final BigDecimal PERCENT_UNIT = new BigDecimal(PERCENT_MULTIPLIER);
    private static final int SCALE = 3;

    private final int amount;


    public Money(int amount) {
        if(isMinusMoney(amount))
            throw new IllegalArgumentException("돈은 음수가 불가능합니다.");
        this.amount = amount;
    }

    public Money plus(Money money) {
        return new Money(amount + money.amount);
    }

    public int countBundle(Money bundleUnit) {
        if(bundleUnit.equals(EMPTY) || amount % bundleUnit.amount != 0)
            throw new IllegalArgumentException("묶을 수 없는 단위입니다.");
        return amount / bundleUnit.amount;
    }

    public double rateAsPercent(Money money) {
        BigDecimal baseAmount = new BigDecimal(toString(amount));
        BigDecimal referenceAmount = new BigDecimal(toString(money.amount));

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

    private boolean isMinusMoney(int amount) {
        return amount < EMPTY_MONEY;
    }

    private String toString(int money) {
        return String.valueOf(money);
    }
}

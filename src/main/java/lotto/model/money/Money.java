package lotto.model.money;

import static lotto.common.Error.INVALID_MONEY;
import static lotto.common.Rule.LOTTO_PRICE;

public class Money {
    private final int value;
    private final int count;

    private Money(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public static Money from(int number) {
        validateNumber(number);
        int count = number / LOTTO_PRICE.getNumber();
        return new Money(number / count, count);
    }

    public static Money of(int number, int count) {
        return new Money(number, count);
    }

    private static void validateNumber(int number) {
        if (number % LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        }
        if (number == 0) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        }
    }

    public int getCount() {
        return count;
    }

    public double getTotalValue() {
        return (double) value * count;
    }
}

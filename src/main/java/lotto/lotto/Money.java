package lotto.lotto;

import java.text.NumberFormat;

public class Money {

    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public Money(String textValue) {
        int value = Integer.parseInt(textValue);
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int buy(int amount) {
        validateChange(amount);
        return value / amount;
    }

    private void validateChange(int amount) {
        if (value % amount != 0) {
            throw new IllegalArgumentException();
        }
    }

    public double getRateBy(Money money) {
        return ((double) (value - money.value) / money.value) * 100;
    }

    @Override
    public String toString() {
        return NumberFormat.getNumberInstance().format(value);
    }
}

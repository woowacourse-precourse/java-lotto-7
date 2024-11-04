package lotto.lotto.value;

import java.text.NumberFormat;

public class Money {

    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public Money(String textValue) {
        try {
            int value = Integer.parseInt(textValue);
            validate(value);
            this.value = value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
        }
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
        double percentage = ((double) money.getValue() / this.value) * 100;
        return Math.round(percentage * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return NumberFormat.getNumberInstance().format(value);
    }
}

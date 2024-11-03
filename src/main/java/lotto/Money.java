package lotto;

public record Money(int value) {

    public Money {
        validate(value);
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
}

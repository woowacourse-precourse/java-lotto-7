package model;

public class Money {

    private final long value;

    private Money(final long value) {
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }
}

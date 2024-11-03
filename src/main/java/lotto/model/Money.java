package lotto.model;

public class Money {
    private final int value;

    public Money(final String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Money money)) {
            return false;
        }
        return this.value == money.value;
    }
}

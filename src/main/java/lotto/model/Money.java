package lotto.model;

public class Money {
    private final int value;

    public Money(final int value) {
        this.value = value;
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

package lotto.domain;

public class Money {
    private int value;

    public Money(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

}

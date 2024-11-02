package lotto.enumValue;

public enum Number {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    ZERO(0);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getValue() {
        return number;
    }
}

package lotto.model.calculator;

public enum Prize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final long prize;

    Prize(long prize) {
        this.prize = prize;
    }

    public long get() {
        return prize;
    }
}
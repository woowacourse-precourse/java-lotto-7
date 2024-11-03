package lotto.domain;

public enum Prize {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    MISS(0),
    ;

    private final int amount;

    Prize(final int amount) {
        this.amount = amount;
    }
}

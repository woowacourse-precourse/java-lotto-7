package lotto.model;

public enum Rank {
    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L),
    NO_LUCK(0L),
    ;

    private long price;

    Rank(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}

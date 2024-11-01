package lotto.domain;

public enum WinningStatistics {

    FIRST(6,2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3,5_000);

    private final int match;
    private final int price;

    WinningStatistics(final int match, final int price) {
        this.match = match;
        this.price = price;
    }

    public int getMatchValue() {
        return match;
    }

    public int getPrice() {
        return price;
    }
}

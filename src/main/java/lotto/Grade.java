package lotto;

public enum Grade {
    MATCH_NONE(0,0),
    MATCH3(3,  5_000),
    MATCH4(4, 50_000),
    MATCH5(5, 1_500_000),
    MATCH5_BONUS(5,30_000_000),
    MATCH6(6,  2_000_000_000);

    private final int matchCount;
    private final int price;

    Grade(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }
}

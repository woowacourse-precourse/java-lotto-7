package Common;


public enum Rank {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    FIVE_MATCHES_WITH_BONUS(5, 30000000),
    SIX_MATCHES(6, 2000000000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private int prizeCount = 0;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeCount = 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrizeCount() {
        this.prizeCount = 1;
    }

    public int getPrizeCount() {
        return prizeCount;
    }
}

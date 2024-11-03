package lotto.model;

public enum Winnings {
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000,6);

    private final double prize;
    private final int matchCount;

    Winnings(double prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public double getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }


}

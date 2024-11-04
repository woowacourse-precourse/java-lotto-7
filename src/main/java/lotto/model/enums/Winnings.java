package lotto.model.enums;

public enum Winnings {
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000,6);

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

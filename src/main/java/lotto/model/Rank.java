package lotto.model;

public enum Rank {
    FIFTH(3, 5_000, "5등"),
    FOURTH(4, 50_000, "4등"),
    THIRD(5, 1_500_000, "3등"),
    SECOND(5, 30_000_000, "2등"),
    FIRST(6, 2_000_000_000, "1등");

    private final int matchCount;
    private final int prize;
    private final String name;

    Rank(int matchCount, int prize, String name) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.name = name;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getName() {
        return name;
    }
}

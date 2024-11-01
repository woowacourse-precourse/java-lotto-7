import java.util.List;

public enum Rank {
    FIRST(6, 2000000000, "1등"),
    SECOND(5, 30000000, "2등"),
    THIRD(5, 1500000, "3등"),
    FOURTH(4, 50000, "4등"),
    FIFTH(3, 5000, "5등");

    private final int matchCount;
    private final int prize;
    private final String name;

    Rank(int matchCount, int prize, String name) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.name = name;
    }

    public int getPrize() {
        return prize;
    }

    public String getName() {
        return name;
    }

}

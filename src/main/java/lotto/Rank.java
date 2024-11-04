package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    MISS(0,0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus){
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }

    public int getPrize() {
        return prize;
    }
}

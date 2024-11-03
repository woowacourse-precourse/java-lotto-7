package lotto;

public enum Rank {
    FIRST(2000000),
    SECOND(30000),
    THIRD(1500),
    FOURTH(50),
    FIFTH(5);

    private final int prize;

    Rank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
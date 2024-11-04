package lotto.domain;

public enum Winning {

    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int match;
    private final int prize;

    Winning(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public Winning valueOf(int match) {
        for (Winning winning : Winning.values()) {
            if (match == winning.match) {
                return winning;
            }
        }
        return null;
    }
}

package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000, 1),
    SECOND(5, 30000000, 2),
    THIRD(5, 1500000, 3),
    FOURTH(4, 50000, 4),
    FIFTH(3, 5000, 5),
    NONE(0, 0, 0);

    private final long matched;
    private final long prize;
    private final int rank;

    Rank(long matched, long prize, int rank) {
        this.matched = matched;
        this.prize = prize;
        this.rank = rank;
    }

    public long getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    public static Rank getRank(long matched, boolean hasBonus) {
        if (matched == FIRST.matched) {
            return FIRST;
        }
        if (matched == SECOND.matched && hasBonus) {
            return SECOND;
        }
        if (matched == THIRD.matched) {
            return THIRD;
        }
        if (matched == FOURTH.matched) {
            return FOURTH;
        }
        if (matched == FIFTH.matched) {
            return FIFTH;
        }
        return NONE;
    }
}

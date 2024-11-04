package lotto.model;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int prize;

    Rank(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount, boolean isBonusMatch) {
        if (matchCount == FIRST.getCountOfMatch()) {
            return FIRST;
        }
        if (matchCount == SECOND.getCountOfMatch() && isBonusMatch) {
            return SECOND;
        }
        if (matchCount == THIRD.getCountOfMatch()) {
            return THIRD;
        }
        if (matchCount == FOURTH.getCountOfMatch()) {
            return FOURTH;
        }
        if (matchCount == FIFTH.getCountOfMatch()) {
            return FIFTH;
        }
        return MISS;
    }
}
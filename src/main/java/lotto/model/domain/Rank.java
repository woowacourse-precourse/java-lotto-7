package lotto.model.domain;

public enum Rank {

    NONE(0, 0, 0),
    FIFTH(3, 0, 5_000),
    FOURTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, 0, 2_000_000_000);

    private final int matchCount;
    private final int bonusCount;
    private final int prize;

    Rank(int matchCount, int bonusCount, int prize) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, int bonusCount) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusCount == 1) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public long getMoney() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }
}

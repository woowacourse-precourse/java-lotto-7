package lotto.domain;

public enum Rank {
    FIRST(2_000_000_000, 6, 0),
    SECOND(30_000_000, 5, 1),
    THIRD(1_500_000, 5, 0),
    FOURTH(50_000, 4, 0),
    FIFTH(5_000, 3, 0),
    NONE(0, 0, 0);

    private final int prize;
    private final int basicCount;
    private final int bonusCount;

    Rank(int prize, int basicCount, int bonusCount) {
        this.prize = prize;
        this.basicCount = basicCount;
        this.bonusCount = bonusCount;
    }

    public static Rank calculateRank(int basicCount, int bonusCount) {
        if (basicCount == FIRST.basicCount) {
            return FIRST;
        }
        if (basicCount == SECOND.basicCount && bonusCount == SECOND.bonusCount) {
            return SECOND;
        }
        if (basicCount == THIRD.basicCount && bonusCount == THIRD.bonusCount) {
            return THIRD;
        }
        if (basicCount == FOURTH.basicCount) {
            return FOURTH;
        }
        if (basicCount == FIFTH.basicCount) {
            return FIFTH;
        }

        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getBasicCount() {
        return basicCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }
}

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
        for (Rank rank : Rank.values()) {
            if (isRankMatched(basicCount, bonusCount, rank)) {
                return rank;
            }
        }

        return NONE;
    }

    private static boolean isRankMatched(int basicCount, int bonusCount, Rank rank) {
        return basicCount == rank.basicCount && bonusCount == rank.bonusCount;
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

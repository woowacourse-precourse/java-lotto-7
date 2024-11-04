package lotto.util;

public enum Ranking {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, false, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    NONE(0, 0, false, 0);

    private final int rankCode;
    private final int matchingCount;
    private final boolean hasBonusNumber;
    private final int prize;

    Ranking(int rankCode, int matchingCount, boolean hasBonusNumber, int prize) {
        this.rankCode = rankCode;
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public static Ranking getRanking(int matchingCount, boolean hasBonusNumber) {
        for (Ranking rank : Ranking.values()) {
            if (rank.matches(matchingCount, hasBonusNumber)) {
                return rank;
            }
        }
        return NONE;
    }

    private boolean matches(int matchingCount, boolean hasBonusNumber) {
        return this.matchingCount == matchingCount && this.hasBonusNumber == hasBonusNumber;
    }
}

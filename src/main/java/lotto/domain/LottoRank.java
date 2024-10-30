package lotto.domain;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchingCount;
    private final int prize;

    LottoRank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank getRankByMatchingCountAndBonus(int matchingCount, boolean containsBonusNumber) {
        if (matchingCount == 6) {
            return FIRST;
        }
        if (matchingCount == 5 && containsBonusNumber) {
            return SECOND;
        }
        if (matchingCount == 5) {
            return THIRD;
        }
        if (matchingCount == 4) {
            return FOURTH;
        }
        if (matchingCount == 3) {
            return FIFTH;
        }
        return NONE;
    }
}

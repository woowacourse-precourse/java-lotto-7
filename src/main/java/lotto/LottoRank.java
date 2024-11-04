package lotto;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchingCount;
    private final int prizeAmount;

    LottoRank(int matchingCount, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank fromMatchingCount(int matchingCount, boolean bonusMatched) {
        if (matchingCount == FIRST.matchingCount) {
            return FIRST;
        }
        if (matchingCount == SECOND.matchingCount && bonusMatched) {
            return SECOND;
        }
        if (matchingCount == THIRD.matchingCount) {
            return THIRD;
        }
        if (matchingCount == FOURTH.matchingCount) {
            return FOURTH;
        }
        if (matchingCount == FIFTH.matchingCount) {
            return FIFTH;
        }
        return null;
    }
}


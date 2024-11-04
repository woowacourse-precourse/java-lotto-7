package lotto.domain;

public enum Ranking {
    FAIL(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6);

    private final int prizeAmount;
    private final int matchingCount;
    private final boolean hasBonus;

    Ranking(int prizeAmount, int matchingCount) {
        this.prizeAmount = prizeAmount;
        this.matchingCount = matchingCount;
        this.hasBonus = false;
    }

    Ranking(int prizeAmount, int matchingCount, boolean hasBonus) {
        this.prizeAmount = prizeAmount;
        this.matchingCount = matchingCount;
        this.hasBonus = hasBonus;
    }

    public static Ranking getRanking(int matchNumbersCount, boolean bonusMatch) {
        if (matchNumbersCount == 6) {
            return FIRST;
        }
        if (matchNumbersCount == 5) {
            return getSecondOrThirdRanking(bonusMatch);
        }
        if (matchNumbersCount == 4) {
            return FOURTH;
        }
        if (matchNumbersCount == 3) {
            return FIFTH;
        }
        return FAIL;
    }

    private static Ranking getSecondOrThirdRanking(boolean bonusMatch) {
        if (bonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

    public int getPrizeAmount() { // 상금 금액
        return prizeAmount;
    }

    public int getMatchingCount() { // 일치 개수
        return matchingCount;
    }

    public boolean hasBonus() { // 보너스 볼 일치 개수
        return hasBonus;
    }
}

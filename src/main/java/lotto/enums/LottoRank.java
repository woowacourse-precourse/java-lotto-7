package lotto.enums;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchingCount;
    private final int prize;
    private final boolean bonusRequired;

    LottoRank(int matchingCount, int prize) {
        this(matchingCount, prize, false);
    }

    LottoRank(int matchingCount, int prize, boolean bonusRequired) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.bonusRequired = bonusRequired;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusRequired() {
        return bonusRequired;
    }
}

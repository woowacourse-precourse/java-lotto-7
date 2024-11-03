package lotto.domain;

public enum LottoPrize {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeAmount;

    LottoPrize(int matchCount, boolean bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoPrize decidePrize(int matchCount, boolean bonusMatch) {
        for (LottoPrize prize : values()) {
            if (prize.isMatches(matchCount, bonusMatch)) {
                return prize;
            }
        }

        return null;
    }

    public boolean isMatches(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount && this.bonusMatch == bonusMatch;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치%s (%d원)",
                matchCount,
                bonusMatch ? ", 보너스 볼 일치" : "",
                prizeAmount);
    }
}

package lotto;

public enum LottoRank {
    NO_PRIZE(0, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prize = prizeAmount;
    }

    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST_PRIZE.matchCount) {
            return FIRST_PRIZE;
        }
        if (matchCount == SECOND_PRIZE.matchCount && matchBonus) {
            return SECOND_PRIZE;
        }
        if (matchCount == THIRD_PRIZE.matchCount && !matchBonus) {
            return THIRD_PRIZE;
        }
        if (matchCount == FOURTH_PRIZE.matchCount) {
            return FOURTH_PRIZE;
        }
        if (matchCount == FIFTH_PRIZE.matchCount) {
            return FIFTH_PRIZE;
        }
        return NO_PRIZE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getFormatPrize() {
        return String.format("%,d", prize);
    }

    public int getPrize() {
        return prize;
    }
}

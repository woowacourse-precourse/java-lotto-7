package lotto;

public enum LottoRank {
    NO_PRIZE(0, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeAmount;

    LottoRank(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST_PRIZE;
        }
        if (matchCount == 5) {
            return checkSecondOrThird(matchBonus);
        }
        if (matchCount == 4) {
            return FOURTH_PRIZE;
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE;
        }
        return NO_PRIZE;
    }

    private static LottoRank checkSecondOrThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}

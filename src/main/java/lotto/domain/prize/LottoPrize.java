package lotto.domain.prize;

public enum LottoPrize {

    FIRST_PRIZE(6, false, 2000000000),
    SECOND_PRIZE(5,false, 30000000),
    THIRD_PRIZE(5, false, 1500000),
    FOURTH_PRIZE(4, true, 50000),
    FIFTH_PRIZE(3, false, 5000),
    NONE(0, false, 0)
    ;

    private final int matchCount;
    private final boolean isBonusNumberMatchRequired;
    private final int prize;

    LottoPrize(int matchCount, boolean isBonusNumberMatchRequired, int prize) {
        this.matchCount = matchCount;
        this.isBonusNumberMatchRequired = isBonusNumberMatchRequired;
        this.prize = prize;
    }

    public static LottoPrize getLottoPrize(int matchCount, boolean isBonusNumberMatch) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if(lottoPrize.matchCount == matchCount && lottoPrize.isBonusNumberMatchRequired == isBonusNumberMatch) {
                return lottoPrize;
            }
        }
        return LottoPrize.NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNumberMatchRequired() {
        return isBonusNumberMatchRequired;
    }

    public int getPrize() {
        return prize;
    }
}

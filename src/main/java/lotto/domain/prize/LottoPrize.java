package lotto.domain.prize;

public enum LottoPrize {

    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5,true, 30000000),
    FIRST_PRIZE(6, false, 2000000000),
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
        if(matchCount == LottoPrize.SECOND_PRIZE.matchCount && isBonusNumberMatch) {
            return LottoPrize.SECOND_PRIZE;
        }
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if(lottoPrize.matchCount == matchCount)
                return lottoPrize;
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

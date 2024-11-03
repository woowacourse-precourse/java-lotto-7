package lotto.utils.constants;

public enum LottoPrize {
    LOTTO_MATCH_ZERO(0, 0),
    LOTTO_MATCH_5TH(3, 5000),
    LOTTO_MATCH_4TH(4, 50000),
    LOTTO_MATCH_3RD(5, 1500000),
    LOTTO_MATCH_2ND(5, 30000000),
    LOTTO_MATCH_1ST(6, 2000000000);

    private final int matchCount;
    private final int lottoPrize;

    LottoPrize(int matchCount, int lottoPrize) {
        this.matchCount = matchCount;
        this.lottoPrize = lottoPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getLottoPrize() {
        return lottoPrize;
    }

    public static LottoPrize findPrize(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {return LottoPrize.LOTTO_MATCH_1ST;}

        if (matchCount == 5 && bonusMatch) {return LottoPrize.LOTTO_MATCH_2ND;}

        if (matchCount == 5) {return LottoPrize.LOTTO_MATCH_3RD;}

        if (matchCount == 4) {return LottoPrize.LOTTO_MATCH_4TH;}

        if (matchCount == 3) {return LottoPrize.LOTTO_MATCH_5TH;}

        return LottoPrize.LOTTO_MATCH_ZERO;
    }

}

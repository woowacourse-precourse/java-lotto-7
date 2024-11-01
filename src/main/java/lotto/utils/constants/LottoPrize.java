package lotto.utils.constants;

public enum LottoPrize {
    LOTTO_MATCH_THREE(3, 5000),
    LOTTO_MATCH_FOUR(4, 50000),
    LOTTO_MATCH_FIVE(5, 1500000),
    LOTTO_MATCH_BONUS(5, 30000000),
    LOTTO_MATCH_SIX(6, 2000000000);

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
}

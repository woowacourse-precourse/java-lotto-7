package lotto.model;

public enum LottoResult {
    THREE_NUMBER_MATCH(3, 5000),
    FOUR_NUMBER_MATCH(4, 50000),
    FIVE_NUMBER_MATCH(5, 1500000),
    FIVE_NUMBER_AND_BONUS_NUMBER_MATCH(5, 30000000),
    SIX_NUMBER_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prize;

    LottoResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int lottoMatchCount() {
        return matchCount;
    }

    public int lottoPrize() {
        return prize;
    }

    public static boolean isBonusNumberMatched(int matchCount, boolean bonusMatch) {
        return matchCount == 5 && bonusMatch;
    }
}

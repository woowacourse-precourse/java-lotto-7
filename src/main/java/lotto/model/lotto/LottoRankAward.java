package lotto.model.lotto;

public enum LottoRankAward {

    FIFTH_RANK(3, 5_000, false),
    FORTH_RANK(4,  50_000, false),
    THIRD_RANK(5,  1_500_000,false),
    SECOND_RANK(5, 30_000_000, true),
    FIRST_RANK(6, 2_000_000_000, false);

    private final int matchedNumberCount;
    private final int prizeAmount;
    private final boolean isBonusNumberMatched;

    LottoRankAward(int matchedNumberCount, int prizeAmount, boolean isBonusNumberMatched) {
        this.matchedNumberCount = matchedNumberCount;
        this.prizeAmount = prizeAmount;
        this.isBonusNumberMatched = isBonusNumberMatched;
    }

    public int getMatchLottoNumberCount() {
        return matchedNumberCount;
    }

    public int getWinningMoneyPrize() {
        return prizeAmount;
    }

    public boolean getIsBonusMatched() {
        return isBonusNumberMatched;
    }

    public static LottoRankAward findLottoRank(int matchedCount, boolean isBonusNumberMatched) {
        for (LottoRankAward rank : values()) {
            if (rank.matchedNumberCount == matchedCount && rank.isBonusNumberMatched == isBonusNumberMatched) {
                return rank;
            }
        }
        return null;
    }
}

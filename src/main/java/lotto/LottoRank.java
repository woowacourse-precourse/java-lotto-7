package lotto;

public enum LottoRank {
    LOTTO_RANK_FIFTH(3, false, 5_000),
    LOTTO_RANK_FOURTH(4, false, 50_000),
    LOTTO_RANK_THIRD(5, false, 1_500_000),
    LOTTO_RANK_SECOND(5, true, 30_000_000),
    LOTTO_RANK_FIRST(6, false, 2_000_000_000),
    LOTTO_RANK_NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonusNumber;
    private final int prizeAmount;

    LottoRank(int matchCount, boolean matchBonusNumber, int prizeAmount) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}

package lotto.domain;

public enum LottoRank {
    FiFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ETC(-1, false, 0);

    private final int correctCnt;
    private final boolean isBonusNumberRequired;
    private final int winningAmount;

    LottoRank(int correctCnt, boolean isBonusNumberRequired, int winningAmount) {
        this.correctCnt = correctCnt;
        this.isBonusNumberRequired = isBonusNumberRequired;
        this.winningAmount = winningAmount;
    }

    public int getCorrectCnt() {
        return correctCnt;
    }

    public boolean isBonusNumberRequired() {
        return isBonusNumberRequired;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}

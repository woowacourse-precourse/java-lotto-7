package lotto.model;

public class LottoResult {
    private final int winningResult;
    private final boolean bonusResult;

    public LottoResult(int winningResult, boolean bonusResult) {
        this.winningResult = winningResult;
        this.bonusResult = bonusResult;
    }

    public int getWinningResult() {
        return winningResult;
    }

    public boolean isBonusResult() {
        return bonusResult;
    }
}

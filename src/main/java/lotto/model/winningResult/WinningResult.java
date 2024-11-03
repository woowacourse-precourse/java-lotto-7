package lotto.model.winningResult;

import lotto.model.winnerRank.WinnerRank;

public class WinningResult {
    private final WinnerRank winnerRank;
    private int winningLottoAmount;

    public WinningResult(WinnerRank winnerRank) {
        this.winnerRank = winnerRank;
        this.winningLottoAmount = 0;
    }

    public void addLottoAmount() {
        winningLottoAmount++;
    }

    public boolean correspondsTo(WinnerRank winnerRank) {
        if (this.winnerRank.equals(winnerRank)) {
            return true;
        }
        return false;
    }

    public int getWinningLottoAmount() {
        return winningLottoAmount;
    }
}

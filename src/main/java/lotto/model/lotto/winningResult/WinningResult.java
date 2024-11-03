package lotto.model.lotto.winningResult;

import lotto.model.lotto.winningResult.rank.Rank;

public class WinningResult {
    private final Rank rank;
    private int winningLottoAmount;

    public WinningResult(Rank rank) {
        this.rank = rank;
        this.winningLottoAmount = 0;
    }

    public void addLottoAmount() {
        winningLottoAmount++;
    }

    public boolean correspondsTo(Rank rank) {
        if (this.rank.equals(rank)) {
            return true;
        }
        return false;
    }

    public int getWinningLottoAmount() {
        return winningLottoAmount;
    }
}

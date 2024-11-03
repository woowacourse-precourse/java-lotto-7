package lotto.model.winningResult;

public class WinningResult {
    private final WinningRank winningRank;
    private int winningLottoAmount;

    public WinningResult(WinningRank winningRank) {
        this.winningRank = winningRank;
        this.winningLottoAmount = 0;
    }

    public void addLottoAmount() {
        winningLottoAmount++;
    }

    public boolean correspondsTo(WinningRank winningRank) {
        if (this.winningRank.equals(winningRank)) {
            return true;
        }
        return false;
    }

    public int getWinningLottoAmount() {
        return winningLottoAmount;
    }
}

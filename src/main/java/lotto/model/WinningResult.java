package lotto.model;

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

    public WinningRank getWinningRank() {
        return winningRank;
    }

    public int getWinningLottoAmount() {
        return winningLottoAmount;
    }
}

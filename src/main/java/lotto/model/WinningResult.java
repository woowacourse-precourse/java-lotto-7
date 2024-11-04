package lotto.model;

public class WinningResult {
    private Lotto purchasedLotto;
    private Lotto winningLotto;
    private Integer winningRank;
    private Integer winningPrice;

    public WinningResult(Lotto purchasedLotto,
                         Lotto winningLotto,
                         Integer winningRank,
                         Integer winningPrice) {
        this.purchasedLotto = purchasedLotto;
        this.winningLotto = winningLotto;
        this.winningRank = winningRank;
        this.winningPrice = winningPrice;
    }

    public Integer getWinningRank() {
        return winningRank;
    }

    public Integer getWinningPrice() {
        return winningPrice;
    }
}

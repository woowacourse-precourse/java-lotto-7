package lotto.model;

public class WinningAmountCalculator {
    private Lotto winningLotto;

    public WinningAmountCalculator(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public boolean isFirstPrize(Lotto purchasedLotto) {
        return true;
    }
}

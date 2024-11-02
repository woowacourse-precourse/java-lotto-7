package lotto.domain;

public class Lottery {
    private final PurchaseLotto purchaseLotto;
    private final WinningNumber winningNumber;

    public Lottery(PurchaseLotto purchaseLotto, WinningNumber winningNumber) {
        this.purchaseLotto = purchaseLotto;
        this.winningNumber = winningNumber;
    }
}

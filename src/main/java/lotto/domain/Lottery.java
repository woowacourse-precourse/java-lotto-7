package lotto.domain;

public class Lottery {
    private final PurchaseLotto purchaseLotto;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public Lottery(PurchaseLotto purchaseLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.purchaseLotto = purchaseLotto;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}

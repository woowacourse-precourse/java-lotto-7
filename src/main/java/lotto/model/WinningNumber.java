package lotto.model;

public class WinningNumber {
    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}

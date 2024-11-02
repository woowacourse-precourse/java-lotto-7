package lotto.model;

public class WinningCriteria {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningCriteria(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}

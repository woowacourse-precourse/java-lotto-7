package lotto.model;

public class WinningCriteria {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningCriteria(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

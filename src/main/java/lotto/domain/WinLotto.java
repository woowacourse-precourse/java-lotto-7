package lotto.domain;

public class WinLotto {

    private Lotto lotto;
    private int bonusNumber;

    private WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static WinLotto of(Lotto lotto, int bonusNumber) {
        return new WinLotto(lotto, bonusNumber);
    }
}

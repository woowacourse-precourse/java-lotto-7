package lotto.model;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getNumber() {
        return winningLotto;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}

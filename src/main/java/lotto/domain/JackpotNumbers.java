package lotto.domain;

public class JackpotNumbers {

    private Lotto lotto;
    private int bonusNumber;

    public JackpotNumbers() {
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
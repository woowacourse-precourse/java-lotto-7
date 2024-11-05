package lotto.domain;

public class JackpotNumbers {

    private final Lotto lotto;
    private final int bonusNumber;

    public JackpotNumbers(Lotto lotto, int bonusNumber) {
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
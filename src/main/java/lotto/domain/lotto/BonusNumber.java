package lotto.domain.lotto;

public class BonusNumber {

    private int number;

    public BonusNumber() {
        this.number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void updateNumber(int bonusNumber) {
        this.number = bonusNumber;
    }
}

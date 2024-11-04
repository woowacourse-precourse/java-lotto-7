package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getNumber() {
        return bonusNumber;
    }

    public boolean isValid() {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }
}

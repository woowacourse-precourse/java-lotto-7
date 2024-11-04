package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

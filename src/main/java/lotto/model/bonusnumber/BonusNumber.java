package lotto.model.bonusnumber;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumberInput) {
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public int get() {
        return bonusNumber;
    }
}



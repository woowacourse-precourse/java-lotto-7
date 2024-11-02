package lotto.models;

public class Bonus {

    private final int bonusNumber;

    public Bonus (String bonusNumberInput) {
        this.bonusNumber = stringToInt(bonusNumberInput);
    }

    private int stringToInt(String bonusNumberInput) {
        return Integer.parseInt(bonusNumberInput);
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}

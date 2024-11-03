package lotto.model;

import java.util.List;
import lotto.helper.valid.ValidBonus;

public class Bonus {
    private int bonusNumber;

    public Bonus(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        ValidBonus.checkDuplicateNumber(numbers, bonusNumber);
        ValidBonus.checkRangeNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

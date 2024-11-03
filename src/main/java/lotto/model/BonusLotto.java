package lotto.model;

import java.util.List;
import lotto.util.RangeValidator;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber) {
        RangeValidator.numberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void bonusDuplicate(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

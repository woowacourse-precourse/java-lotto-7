package lotto;

import java.util.List;

import static lotto.ErrorMessages.ERROR_BONUS_NUMBER_DUPLICATE;
import static lotto.ErrorMessages.ERROR_LOTTO_NUMBER_RANGE;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

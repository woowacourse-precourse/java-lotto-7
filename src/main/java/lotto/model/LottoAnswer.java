package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoErrorMessage;

public class LottoAnswer extends Lotto {
    private final int bonusNumber;

    public LottoAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicated(bonusNumber);
    }

    private void validateBonusNumberDuplicated(int bonusNumber) {
        var numbers = new HashSet<>(super.getNumbers());

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}

package lotto.domain;

import static lotto.constants.CommonConstants.LOTTO_NUMBER_MAX;
import static lotto.constants.CommonConstants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.enums.ErrorCode;
import lotto.exception.CommonException;

public class Guess extends Lotto {
    private final int bonusNumber;

    public Guess(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new CommonException(ErrorCode.INVALID_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new CommonException(ErrorCode.DUPLICATE_BONUS_NUMBER);
        }
    }

}

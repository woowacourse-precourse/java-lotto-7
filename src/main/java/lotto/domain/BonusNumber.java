package lotto.domain;

import lotto.exception.BonusNumberDuplicateException;
import lotto.exception.NumberOutOfRangeException;
import java.util.List;

import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.MAX_NUMBER;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void validate(int bonusNumber, List<Integer> winningLotto) {
        validateBonusNumberInRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, winningLotto);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }

    private void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
    }
}

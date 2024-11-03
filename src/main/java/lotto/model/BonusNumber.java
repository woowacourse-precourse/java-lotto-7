package lotto.model;

import lotto.exception.InvalidBonusNumberException;

import java.util.List;

import static lotto.exception.ErrorMessage.ALREADY_EXIST_IN_WINNING_NUMBERS;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.model.Lotto.MIN_LOTTO_NUMBER;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumber) {
        this.bonusNumber = bonusNumber;
        validate(bonusNumber, winningNumber);
    }

    public int get() {
        return bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> winningNumber) {
        checkHasValidRange(bonusNumber);
        checkHasDuplicate(bonusNumber, winningNumber);
    }

    private void checkHasValidRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new InvalidBonusNumberException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void checkHasDuplicate(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new InvalidBonusNumberException(ALREADY_EXIST_IN_WINNING_NUMBERS.getMessage());
        }
    }
}

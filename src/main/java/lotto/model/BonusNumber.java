package lotto.model;

import static lotto.ExceptionMessage.BONUS_NUMBER_DUPLICATE_EXCEPTION;
import static lotto.ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> winningNumbers) {
        validateNumbersRange(bonusNumber);
        validateNoDuplicateNumbers(bonusNumber, winningNumbers);
    }

    private void validateNumbersRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION.message());
        }
    }

    private void validateNoDuplicateNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION.message());
        }
    }
}

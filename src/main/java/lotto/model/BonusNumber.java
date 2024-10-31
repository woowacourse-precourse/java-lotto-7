package lotto.model;

import static lotto.ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, List<Integer> winningNumbers) {
        validateNumbersRange(bonusNumber);
    }

    private void validateNumbersRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION.message());
        }
    }
}

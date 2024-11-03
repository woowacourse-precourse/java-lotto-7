package lotto.model;

import java.util.List;
import message.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberIsInRange(bonusNumber);
        validateBonusNumberUniqueness(bonusNumber, winningNumbers);
    }

    private void validateBonusNumberIsInRange(int bonusNumber) {
        if (isNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.message());
        }
    }

    private void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.message());
        }
    }

    private boolean isNumberOutOfRange(int number) {
        return number < 1 || number > 45;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

package lotto.model.domain;

import lotto.exception.InputErrorMessage;

public class BonusNumber {
    private final static int MAX_BONUS = 45;
    private final static int MIN_BONUS = 1;

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumbers winningNumbers) {
        validateRange(bonusNumber);
        validateDuplicates(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private static void validateRange(int bonus) {
        if (bonus < MIN_BONUS || bonus > MAX_BONUS) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_BONUS_RANGE.getMessage());
        }
    }

    private static void validateDuplicates(int bonus, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(InputErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
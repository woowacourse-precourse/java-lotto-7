package lotto.domain;

import lotto.exception.ErrorMessage;

public record BonusNumber(int bonusNumber) {

    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 45;

    public BonusNumber {
        validateRange(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < START_OF_RANGE || bonusNumber > END_OF_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE_NOT_MATCH.getMessage());
        }
    }
}

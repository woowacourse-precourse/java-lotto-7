package lotto.model.lotto;

import lotto.common.ErrorMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int bonus;

    public BonusNumber(final String bonusNumber) {
        int bonus = convertToInt(bonusNumber);
        validateRange(bonus);
        this.bonus = bonus;
    }

    private int convertToInt(final String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_CONVERT_TO_INT.getMessage());
        }
    }

    private void validateRange(final int bonus) {
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    int getBonus() {
        return bonus;
    }
}

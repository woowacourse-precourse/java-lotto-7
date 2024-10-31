package lotto.model;

import java.util.Objects;
import lotto.exception.ErrorMessage;

public class BonusNumber {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private final int bonusNumber;

    protected BonusNumber(int bonusNumber) {
        validateOutOfRangeNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validateOutOfRangeNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER_RANGE || bonusNumber > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bonusNumber);
    }
}

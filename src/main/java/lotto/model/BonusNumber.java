package lotto.model;

import static lotto.enums.Constants.MAX_LOTTO_NUM;
import static lotto.enums.Constants.MIN_LOTTO_NUM;
import static lotto.enums.ExceptionMessage.INVALID_LOTTO_NUM_RANGE;
import static lotto.enums.ExceptionMessage.INVALID_WINNING_NUM_DUPLICATE;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber,Lotto lotto) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber,lotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    private void validateRange(int bonusNumber) {

        if (bonusNumber < MIN_LOTTO_NUM.getValue() || bonusNumber > MAX_LOTTO_NUM.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM_RANGE.getMessage());
        }
    }

    private void validateDuplicate(int bonusNumber, Lotto lotto) {
        for (Integer number : lotto.getNumbers()) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(INVALID_WINNING_NUM_DUPLICATE.getMessage());
            }
        }
    }
}

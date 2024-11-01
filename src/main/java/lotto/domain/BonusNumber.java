package lotto.domain;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.view.ErrorMessage;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        checkRange(bonusNumber);
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

package lotto.model;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;
import static lotto.constant.NumberConstant.*;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber) {
        validationBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validationBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN_RANGE || bonusNumber > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}

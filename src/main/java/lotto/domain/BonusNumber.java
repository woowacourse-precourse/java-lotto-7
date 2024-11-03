package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.NumberConstant.*;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateInRange(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_RANGE_START || LOTTO_NUMBER_RANGE_END < bonusNumber) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_RANGE
                    .getMessageWithArgs(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END));
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

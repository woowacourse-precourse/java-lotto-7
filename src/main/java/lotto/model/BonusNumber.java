package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        validateIsBlank(bonusNumber);
    }

    private void validateIsBlank(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK.get());
        }
    }
}

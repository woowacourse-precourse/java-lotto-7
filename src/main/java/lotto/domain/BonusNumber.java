package lotto.domain;

import static lotto.utils.Constant.COMMA;

import global.errorMessage.BonusNumberErrorMessage;
import global.errorMessage.NumberErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String input) {
        validateBonusNumber(input);
        this.bonusNumber = Integer.parseInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(String input) {
        if (input.contains(COMMA)) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.INVALID_FORMAT.getMessage());
        }
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}

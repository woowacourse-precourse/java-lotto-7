package lotto.model;

import lotto.Message.ErrorMessage;
import lotto.Utils;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(String input) {
        int bonusNumber = Utils.parseToInt(input);
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGE.toString());
        }
    }

    public int getNumber() {
        return bonusNumber;
    }
}
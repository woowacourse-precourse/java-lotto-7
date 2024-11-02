package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {

    private static final int NUMBERS_RANGE_START = 1;

    private static final int NUMBERS_RANGE_END = 45;

    private final int bonusNumber;

    public BonusNumber(String inputBonusNumber) {
        this.bonusNumber = validateInteger(inputBonusNumber);
        validateRange();
    }

    private int validateInteger(String inputBonusNumber) {
        int number;
        try {
            number = Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        return number;
    }

    private void validateRange() {
        if (bonusNumber < NUMBERS_RANGE_START || bonusNumber > NUMBERS_RANGE_END) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

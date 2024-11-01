package lotto.model;

import lotto.Message.ErrorMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(String input) {
        int bonusNumber = validateNumber(input);
        validNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.toString());
        }
    }

    private void validNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.toString());
        }
    }

    public int getNumber() {
        return bonusNumber;
    }
}
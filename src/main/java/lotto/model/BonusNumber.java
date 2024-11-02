package lotto.model;

import lotto.Message.ErrorMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(String input) {
        int bonusNumber = validateNumber(input);
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INVALID_NUMBER.toString());
        }
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
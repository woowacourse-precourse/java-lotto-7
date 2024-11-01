package lotto.domain;

import lotto.exception.BonusNumberErrorMessage;

public class BonusNumber {

    private final int number;

    public BonusNumber(String number) {
        int userInput = validateNumber(number);
        validateRange(userInput);

        this.number = userInput;
    }

    public int getNumber() {
        return number;
    }

    private int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.IS_NOT_POSSIBLE_RANGE.getMessage());
        }
    }
}

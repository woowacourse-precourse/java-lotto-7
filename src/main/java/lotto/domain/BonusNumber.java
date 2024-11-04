package lotto.domain;

import lotto.constants.ErrorMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        try {
            int number = Integer.parseInt(input);
            return new BonusNumber(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getFormattedMessage(MIN_NUMBER, MAX_NUMBER));
        }
    }

    private void validate(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isInvalidRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}

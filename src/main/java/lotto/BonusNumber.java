package lotto;

import lotto.exception.InvalidNumberException;

import static lotto.exception.ErrorMessage.*;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(String input, Lotto correctNumber) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateDuplicate(bonusNumber, correctNumber);
            validateRange(bonusNumber);
            return new BonusNumber(bonusNumber);
        } catch(NumberFormatException e) {
            throw new InvalidNumberException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateDuplicate(int number, Lotto correctNumber) {
        if(correctNumber.numbers().contains(number)){
            throw new InvalidNumberException(INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new InvalidNumberException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public int number() {
        return this.number;
    }
}

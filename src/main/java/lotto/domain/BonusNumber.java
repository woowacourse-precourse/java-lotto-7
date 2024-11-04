package lotto.domain;

import lotto.global.message.ErrorMessage;

public class BonusNumber {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(int number) {
        validateNumberInRange(number);
        return new BonusNumber(number);
    }

    private static void validateNumberInRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}

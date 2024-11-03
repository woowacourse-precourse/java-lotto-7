package lotto.domain;

import lotto.global.message.ErrorMessage;

public class BonusNumber {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final long number;

    private BonusNumber(long number) {
        this.number = number;
    }

    public static BonusNumber from(long number) {
        validateNumberInRange(number);
        return new BonusNumber(number);
    }

    private static void validateNumberInRange(long number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private static boolean isOutOfRange(long number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    public long getNumber() {
        return number;
    }
}

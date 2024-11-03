package lotto.domain;

import lotto.global.message.ErrorMessage;

public class BonusNumber {

    private final long number;

    public BonusNumber(long number) {
        validateNumberInRange(number);
        this.number = number;
    }

    private static void validateNumberInRange(long number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private static boolean isOutOfRange(long number) {
        return number < 1 || number > 45;
    }

    public long getNumber() {
        return number;
    }




}

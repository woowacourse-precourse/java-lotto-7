package lotto.application.prize.domain;

import static lotto.application.prize.message.Message.BONUS_SHOULD_BETWEEN_ONE_FOURTYFIVE;
import static lotto.application.prize.message.Message.BONUS_SHOULD_DIFFERENT_FROM_WINNUMBER;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.END_INCLUSIVE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.START_INCLUSIVE;

import lotto.application.ticket.domain.ticket.Lotto;

public class BonusNumber {
    private final int value;

    public BonusNumber(int value) {
        this.value = value;
    }

    public static BonusNumber of(int value, Lotto lotto) {
        validate(value, lotto);
        return new BonusNumber(value);
    }

    public int getValue() {
        return value;
    }

    private static void validate(int value, Lotto lotto) {
        validateNumberRange(value);
        validateDuplicate(value, lotto);
    }

    private static void validateNumberRange(int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(BONUS_SHOULD_BETWEEN_ONE_FOURTYFIVE);
        }
    }

    private static void validateDuplicate(int value, Lotto lotto) {
        if (lotto.contains(value)) {
            throw new IllegalArgumentException(BONUS_SHOULD_DIFFERENT_FROM_WINNUMBER);
        }
    }

    private static boolean isOutOfRange(int value) {
        return value < START_INCLUSIVE.getValue() || value > END_INCLUSIVE.getValue();
    }

}

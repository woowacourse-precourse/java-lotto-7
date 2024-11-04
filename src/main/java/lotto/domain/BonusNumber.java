package lotto.domain;

import static lotto.common.ExceptionMessage.OUT_OF_RANGE_NUMBER;
import static lotto.common.LottoConstant.*;

public record BonusNumber(
        int number
) {
    public BonusNumber {
        validateNumberRange(number);
    }

    public static BonusNumber from(int number) {
        return new BonusNumber(number);
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }
}

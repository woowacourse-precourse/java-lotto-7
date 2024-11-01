package lotto.global.util;

import static lotto.global.constant.ErrorMessage.DUPLICATE_NUMBER_EXIST;

import lotto.Lotto;
import lotto.UniqueNumber;

public class Validator {
    public static void validateLotto(Lotto lotto) {
        validateDuplicateNumber(lotto);
    }

    public static void validateDuplicateNumber(UniqueNumber uniqueNumber) {
        if (uniqueNumber.hasDuplicateNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST);
        }
    }
}

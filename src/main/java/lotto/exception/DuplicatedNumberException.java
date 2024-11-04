package lotto.exception;

import static lotto.error.ErrorMessage.DUPLICATED_LOTTO_NUMBER;

public class DuplicatedNumberException extends IllegalArgumentException {
    private DuplicatedNumberException(final String message) {
        super(message);
    }

    public static DuplicatedNumberException duplicatedLottoNumber() {
        return new DuplicatedNumberException(DUPLICATED_LOTTO_NUMBER);
    }
}

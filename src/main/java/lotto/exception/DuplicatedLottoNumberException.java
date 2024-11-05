package lotto.exception;

import static lotto.constants.ExceptionMessages.DUPLICATED_LOTTO_NUMBER;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    public DuplicatedLottoNumberException() {
        super(DUPLICATED_LOTTO_NUMBER);
    }
}

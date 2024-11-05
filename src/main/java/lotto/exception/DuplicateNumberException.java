package lotto.exception;

import static lotto.constant.LottoErrorMessages.DUPLICATE_NUMBER;

public class DuplicateNumberException extends LottoException {
    public DuplicateNumberException() {
        super(DUPLICATE_NUMBER);
    }
}

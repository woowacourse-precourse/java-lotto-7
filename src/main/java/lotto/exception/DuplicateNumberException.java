package lotto.exception;

import lotto.constant.LottoErrorMessages;

public class DuplicateNumberException extends LottoException {
    public DuplicateNumberException() {
        super(LottoErrorMessages.DUPLICATE_NUMBER.getMessage());
    }
}

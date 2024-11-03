package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.NOT_POSITIVE_INTEGER;

public class NotPositiveIntegerException extends LottoException {

    public NotPositiveIntegerException() {
        super(NOT_POSITIVE_INTEGER.getMessage());
    }
}

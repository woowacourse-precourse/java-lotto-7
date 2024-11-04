package lotto.exception;

import lotto.domain.LottoMarket;

public class LottoException extends RuntimeException{
    private LottoException(final ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}

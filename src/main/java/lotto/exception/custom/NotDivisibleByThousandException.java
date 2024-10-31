package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.NOT_DIVISIBLE_BY_THOUSAND;

public class NotDivisibleByThousandException extends LottoException {

    public NotDivisibleByThousandException() {
        super(NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }
}

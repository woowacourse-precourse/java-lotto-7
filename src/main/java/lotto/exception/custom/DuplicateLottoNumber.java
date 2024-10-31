package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.DUPLICATE_LOTTO_NUMBER;

public class DuplicateLottoNumber extends LottoException {

    public DuplicateLottoNumber() {
        super(DUPLICATE_LOTTO_NUMBER.getMessage());
    }
}

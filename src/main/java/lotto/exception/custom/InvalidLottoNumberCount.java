package lotto.exception.custom;

import lotto.exception.LottoException;

import static lotto.exception.ErrorCode.INVALID_LOTTO_NUMBER_COUNT;

public class InvalidLottoNumberCount extends LottoException {

    public InvalidLottoNumberCount() {
        super(INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }
}

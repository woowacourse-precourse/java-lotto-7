package lotto.domain;

import lotto.exception.LottoException;

import static lotto.exception.LottoExceptionType.OUT_OF_RANGE_LOTTONUMBER;

public record LottoNumber(int lottoNumber) {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public LottoNumber {
        validateLottoNumber(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new LottoException(OUT_OF_RANGE_LOTTONUMBER);
        }
    }
}

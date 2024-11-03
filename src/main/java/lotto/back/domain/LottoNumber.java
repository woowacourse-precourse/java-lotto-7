package lotto.back.domain;

import lotto.global.exception.InvalidLottoNumberRangeException;

import static lotto.global.enums.LottoConstant.*;

public class LottoNumber {
    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(Integer lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER.getNumber() || lottoNumber > MAX_LOTTO_NUMBER.getNumber()) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}

package lotto.back.domain;

import lotto.global.enums.LottoConstant;
import lotto.global.exception.InvalidLottoNumberRangeException;

public class LottoNumber {
    private final Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(Integer lottoNumber) {
        if (lottoNumber < LottoConstant.MIN_LOTTO_NUMBER.getNumber()
                || lottoNumber > LottoConstant.MAX_LOTTO_NUMBER.getNumber()) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}

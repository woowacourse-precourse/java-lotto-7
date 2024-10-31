package lotto.validator;

import lotto.error.LottoError;

public class LottoNumberValidator {
    private final int lottoNumberMin;
    private final int lottoNumberMax;

    public LottoNumberValidator(int lottoNumberMin, int lottoNumberMax) {
        this.lottoNumberMin = lottoNumberMin;
        this.lottoNumberMax = lottoNumberMax;
    }

    public void validateLottoNumber(int lottoNumber) {
        validateMoreThanLottoNumberMin(lottoNumber);
        validateLessThanLottoNumberMax(lottoNumber);
    }

    private void validateMoreThanLottoNumberMin(int lottoNumber) {
        if (lottoNumber < lottoNumberMin) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanLottoNumberMax(int lottoNumber) {
        if (lottoNumber > lottoNumberMax) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage());
        }
    }

}

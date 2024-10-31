package lotto.validator;

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
            throw new IllegalArgumentException();
        }
    }

    private void validateLessThanLottoNumberMax(int lottoNumber) {
        if (lottoNumber > lottoNumberMax) {
            throw new IllegalArgumentException();
        }
    }

}

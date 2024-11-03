package lotto.domain;

public record LottoNumber(int lottoNumber) {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String OUT_OF_RANGE = "로또번호는 1~45의 범위입니다.";

    public LottoNumber {
        validateLottoNumber(lottoNumber);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}

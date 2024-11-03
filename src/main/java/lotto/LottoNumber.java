package lotto;

public class LottoNumber {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static String OUT_OF_RANGE = "로또번호는 1~45의 범위입니다.";
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }
    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER | lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}

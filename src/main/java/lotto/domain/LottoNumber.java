package lotto.domain;

public class LottoNumber {

    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("//여기 enum 에러값");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}

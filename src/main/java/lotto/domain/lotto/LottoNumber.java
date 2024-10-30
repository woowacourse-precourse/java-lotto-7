package lotto.domain.lotto;

import lotto.domain.errors.RangeError;

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
            System.out.println(RangeError.LOTTO_NUMBER_ERROR.getMessage());
            throw new IllegalArgumentException(RangeError.LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}

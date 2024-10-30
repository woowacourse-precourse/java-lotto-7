package lotto.domain.lotto;

import lotto.domain.errors.RangeError;

public class Number {

    public static final int MAXIMUM_NUMBER_RANGE = 45;
    public static final int MINIMUM_NUMBER_RANGE = 1;

    private final int number;

    public Number(int lottoNumber) {
        validate(lottoNumber);
        this.number= lottoNumber;
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < MINIMUM_NUMBER_RANGE || lottoNumber > MAXIMUM_NUMBER_RANGE) {
            System.out.println(RangeError.NUMBER.getMessage());
            throw new IllegalArgumentException(RangeError.NUMBER.getMessage());
        }
    }

    public int getLottoNumber() {
        return number;
    }
}

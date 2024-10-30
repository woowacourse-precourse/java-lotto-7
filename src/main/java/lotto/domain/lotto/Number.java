package lotto.domain.lotto;

import lotto.domain.constants.LottoRule;
import lotto.domain.errors.RangeError;

import static lotto.domain.constants.LottoRule.MAXIMUM_NUMBER_RANGE;

public class Number {

    private final int number;

    public Number(int lottoNumber) {
        validate(lottoNumber);
        this.number= lottoNumber;
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < LottoRule.MINIMUM_NUMBER_RANGE.getValue() || lottoNumber > MAXIMUM_NUMBER_RANGE.getValue()) {
            System.out.println(RangeError.NUMBER.getMessage());
            throw new IllegalArgumentException(RangeError.NUMBER.getMessage());
        }
    }

    public int getLottoNumber() {
        return number;
    }
}

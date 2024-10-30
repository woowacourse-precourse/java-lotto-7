package lotto.domain;

import lotto.validator.LottoNumberValidator;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number){
        LottoNumberValidator.validate(number);
        return new LottoNumber(number);
    }
}

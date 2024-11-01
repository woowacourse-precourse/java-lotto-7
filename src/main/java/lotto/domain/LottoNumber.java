package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private static final List<LottoNumber> CACHE = new ArrayList<>();

    private final int number;

    static {
        IntStream.rangeClosed(0, MAX_LOTTO_NUMBER_RANGE.getValue())
                .mapToObj(LottoNumber::new)
                .forEach(CACHE::add);
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(final int number){
        LottoNumberValidator.validate(number);
        return CACHE.get(number);
    }

    public int getNumber() {
        return number;
    }
}

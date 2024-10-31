package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constants.LottoValue.MAX_LOTTO_NUMBER_RANGE;
import static lotto.constants.LottoValue.MIN_LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private static final List<LottoNumber> CACHE = new ArrayList<>();

    private final int number;

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER_RANGE.getValue(), MAX_LOTTO_NUMBER_RANGE.getValue() + 1)
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
